package uva_solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10305{
    private static int adj[][];
    private static boolean visited[];

    private static void dfs(int num, List<Integer> top){
        visited[num] = true; 
        for(int i = 0; i < adj.length; i++){
            if(adj[num][i] == 1 && !visited[i]){
                dfs(i, top);
            }
        }
        top.add(num);
    }
    public static void main(String[] args) {
        int m,n;
        Scanner sc = new Scanner(System.in);

        boolean first = true;
        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
                 n = Integer.parseInt(st.nextToken());
                 m = Integer.parseInt(st.nextToken());
            adj = new int[n][n];
            visited = new boolean[n];
            for(int i =0; i < n; i++){
                adj[i] = new int[n];
            }
            for(int i = 0; i < m; i++){
                 st = new StringTokenizer(sc.nextLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u-1][v-1] = 1;
            }
           
            List<Integer> topp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    dfs(i,topp);
                }
            }
            if(first){
                first = false;
            }else{
                System.out.println();
            }
            for(int i = topp.size() - 1; i >= 0; i--){
                System.out.print(topp.get(i)+1);
                if(i > 0){
                    System.out.print(" ");
                }
            }
            
        }
    }
}