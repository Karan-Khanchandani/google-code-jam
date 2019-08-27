package uva_solutions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_00821{
    private static int n;
    private static int [][] adj;
    private static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tno = 0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("0 0")){
                break;
            }
            tno++;
            StringTokenizer st = new StringTokenizer(line);
            adj = new int[100][100];
            for(int i = 0; i < 100; i++){
                adj[i] = new int[100];
                Arrays.fill(adj[i], INF);
                adj[i][i] = 0;
            }
            n = 0;
            while(st.hasMoreTokens()){
                int src = Integer.parseInt(st.nextToken());
                int des = Integer.parseInt(st.nextToken());
                n = Math.max(n, src);
                n = Math.max(n, des);
                if(src != 0 && des != 0){
                    adj[src -1][des - 1] = 1;
                }
            }
            for(int k = 0; k < n; k++)
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }

            int count = 0, sum = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i!=j && adj[i][j] != INF){
                        sum += adj[i][j];
                        count++;
                    }
                }
            }
            double ans = ((double) sum)/((double) count);
            System.out.format("Case %d: average length between pages = %.3f clicks\n", tno, ans);
            
        }
    }
}