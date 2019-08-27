package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;


public class uva_11504{
    private static int m,n;
    private static boolean[][] adj;
    private static boolean[] visited;
    private static int[] color;

    private static void dfs(int num, int c){
        visited[num] = true;
        color[num] = c;
        for(int i = 0; i < adj[num].length; i++){
            if(adj[num][i] && !visited[i]){
                dfs(i, c);
            }
        }
    }

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1 ; tno <= t; tno++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            adj = new boolean[n][n];
            for(int i = 0; i < n; i++){
                adj[i] = new boolean[n];
            }
            visited = new boolean[n];
            color = new int[n];

            for(int i = 0; i < m; i++){
                 st = new StringTokenizer(sc.nextLine());
               int  src = Integer.parseInt(st.nextToken());
               int  des = Integer.parseInt(st.nextToken());
                adj[src - 1][des - 1] = true;
            }

            int color = 0;
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    dfs(i, color);
                    color++;
                }
            }

            System.out.println(color);
        }
    }
}