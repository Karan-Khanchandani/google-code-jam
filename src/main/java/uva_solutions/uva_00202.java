package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;


public class uva_00202{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            int num = Integer.parseInt(st.nextToken());
            int den = Integer.parseInt(st.nextToken());
            System.out.printf("%d/%d = ", num, den);
            int con = num/den;
            num %= den;
            int vis[] = new int[den];
            StringBuilder quo = new StringBuilder();
            int time = 1;
            while(vis[num] == 0){
                vis[num] = time++;
                num *= 10;
                quo.append(num/den);
                num %= den;
            }

            String rep = quo.substring(vis[num] - 1);
            String pre = quo.substring(0, vis[num] - 1);

            if(quo.length() <= 50){
                System.out.printf("%d.%s(%s)\n", con, pre, rep);
            }else{
                rep = rep.substring(0, 50 - pre.length());
                System.out.printf("%d.%s(%s...)\n", con, pre, rep);
            }
            System.out.printf("   %d = number of digits in repeating cycle\n\n", quo.length() - pre.length());

        }
    }
}