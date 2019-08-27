package uva_solutions;

import java.util.Arrays;
import java.util.Scanner;

public class uva_00357{
    static int n;
    static long[][] dp;
    static final int UNCAL = -1;
    static int[] m;

    static long ways(int type, int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(type > 4){
            return 0;
        }

        if(dp[type][n] != UNCAL){
            return dp[type][n];
        }
        dp[type][n] = ways(type + 1, n) + ways(type, n - m[type]);
        return dp[type][n];

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp = new long[6][30010];
        m =  new int[]{1,5,10,25,50};
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], UNCAL);
        }
        while(sc.hasNextLine()){
            n = Integer.parseInt(sc.nextLine());
            for(int i = 1; i <= 9; i++)
				ways(0,n/10*i);
            long ans = ways(0,n);
            if(ans == 1){
                System.out.printf("There is only one way to produce %d cents change.\n", n);
            }else{
                System.out.printf("There are %d ways to produce %d cents change.\n", ans, n);
            }
        }
    }
}