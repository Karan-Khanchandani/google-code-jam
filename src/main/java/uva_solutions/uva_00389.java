package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_00389{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int num,  base1,  base2;
            String n = st.nextToken();
            base1 = Integer.parseInt(st.nextToken());
            base2 = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(n, base1);
            String ans = Integer.toString(num, base2);
            if(ans.length() > 7){
                System.out.format("%7s\n", "ERROR");
            }else{
                ans = ans.toUpperCase();
                System.out.format("%7s\n", ans);
            }
        }
    }
}