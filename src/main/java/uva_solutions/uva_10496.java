package uva_solutions;

import java.util.Scanner;

public class uva_10496{
    static int x[], y[], n, dist[][], memo[][];

    static int tsp(int pos, int bitmask){
        if(bitmask == ((1 << (n+1)) - 1)){
            return dist[pos][0];
        }
        if(memo[pos][bitmask] != -1)
            return memo[pos][bitmask];
        
        int ans = 2000000000;
        for(int i = 0; i <= n; i++){
            if(i != pos && (bitmask & (1 << i)) == 0){
                ans = Math.min(ans, dist[pos][i] + tsp(i, bitmask|(1 << i)));
            }
        }
        return memo[pos][bitmask] = ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tno = 1; tno <= t; tno++){
            sc.nextInt();sc.nextInt();
            x = new int[11];
            y = new int[11];
            x[0] = sc.nextInt(); y[0] = sc.nextInt();
            n = sc.nextInt();
            for(int i = 1; i <= n; i++){
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            dist = new int[11][11];
            for(int i = 0; i <= n; i++)
                for(int j = 0; j <= n; j++){
                    dist[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                }
            memo = new int[11][1 << 11];
            for(int i = 0; i < 11; i++)
                for(int j = 0; j < (1 << 11);j++)
                    memo[i][j] = -1;

             System.out.printf("The shortest path has length %d\n", tsp(0, 1)); // DP-TSP

        }
        sc.close();
        System.exit(0);
    }
}