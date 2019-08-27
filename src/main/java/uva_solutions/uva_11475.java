package uva_solutions;

import java.util.Scanner;

public class uva_11475{
    static String s, p;
    static char[] T,P;
    static int m,n;
    static int b[];


    static void kmpProcess(){
        b = new int[m+1];
        b[0] = -1;
        int i = 0, j = -1;
        while(i < m){
            while(j >= 0 && P[i] != P[j]) j = b[j];
            i++; j++;
            b[i] = j;
        }

    }

    static int kmpMatching(){
        kmpProcess();
        int i = 0, j= 0;
        while(i < n){
            while(j >= 0 && T[i] != P[j]) j = b[j];
            i++; j++;
            if(j == m){
                j = -1;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String p = new StringBuilder(s).reverse().toString();
            T = s.toCharArray();
            P = p.toCharArray();
            n = T.length;
            m = P.length;
            int tail = kmpMatching();
            if(tail == -1){
                System.out.println(s);
            }else{
                System.out.print(s + p.substring(tail));
                System.out.println();
            }
        }
    }
}