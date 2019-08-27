package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11576{
    static String s,p;
    static char[] T, P;
    static int m,n,k;
    static int b[];
    static String[] str;
    static void kmpProcess(){
        b = new int[m+1];
        b[0] = -1;
        int i = 0, j = -1;
        while(i < m){
            while(j >=0 && P[i] != P[j]) j = b[j];
            i++;j++;
            b[i] = j;
        }
    }
    static int kmpMatching(){
        kmpProcess();
        int i = 0, j = 0;
        while(i < n){
            while(j >=0 && T[i] != P[j]) j = b[j];
            i++;j++;
            if(j == m){
                return -1;
            }
        }
        return j;
    }
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());;
        for(int tno = 1; tno <= t; tno++){
            int no;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            k = Integer.parseInt(st.nextToken());
            no = Integer.parseInt(st.nextToken());
            str = new String[no];
            for(int i = 0; i < no; i++){
                str[i] = sc.nextLine();
            }

            int count = 0;
            count += str[0].length();
            for(int i = 1; i < no; i++){
                T = str[i-1].toCharArray();
                P = str[i].toCharArray();
                n = T.length;
                m = P.length;
                int tail = kmpMatching();
                if(tail != -1){
                    count += m - tail;
                }
            }
            System.out.println(count);
        }
    }
}