package uva_solutions;

import java.util.Scanner;

public class uva_11173{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int tno = 1; tno <= t; tno++){
            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();
           
                System.out.println(k ^ (k >> 1));
            
        }
    }
}