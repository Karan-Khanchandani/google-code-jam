package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_00927{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            String polynomial = sc.nextLine();
            int d = Integer.parseInt(sc.nextLine());
            int k = Integer.parseInt(sc.nextLine());

            int index = 1, temp = d;
            while(temp < k){
                index++; 
                temp += index*d;    
            }

            //plugin the index
            StringTokenizer st = new StringTokenizer(polynomial);
            int degree = Integer.parseInt(st.nextToken());
            long ans = 0;
            for(int i = 0; i < degree + 1;i++){
                ans += Long.parseLong(st.nextToken())*((long)Math.pow(index, i));
            }

            System.out.println(ans);
        }
    }
}