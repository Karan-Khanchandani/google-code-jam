package uva_solutions;

import java.util.Scanner;


public class uva_10298{
    static String s;
    static String p;
    static char[] T, P;
    static int m,n;
    static int[] b;
    static void kmpProcess(){
        b = new int[m+1];
        b[0] = -1;
        int i = 0, j = -1;
        while(i < m){
            while(j >= 0 && P[i] != P[j]) j = b[j];
            i++;j++;
            b[i] = j;
        }
    }

    static int kmpSearch(){
        int count = 0;
        int i = 0, j = 0;
        while(i < n){
            while(j >= 0 && T[i] != P[j]) j = b[j];
            i++;j++;
            if(j == m){
                count++;
                j = b[j];
            }
            
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            s = sc.nextLine();
            if(s.equals(".")){
                break;
            }
            p = new String(s);
            s = new String(s+s);
            P = p.toCharArray();
            T = s.toCharArray();
            m = P.length;
            n = T.length;
            kmpProcess();
            int count = kmpSearch();
            System.out.println(count - 1);

        }
    }
}