package uva_solutions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_00315{
    private static int[][] adj;
    private static int[] dfs_number;
    private static int[] dfs_parent;
    private static int [] dfs_low;
    private static int dfs_root;
    private static boolean[] articulation_vertex;
    private static int dfsNumCounter;
    private static int rootChildren;
    private static final int UNVISITED = -1;

    private static void findArticulationVertices(int u){
        dfs_number[u] = dfs_low[u] = dfsNumCounter++;
        for(int i = 0; i < adj[u].length; i++){
            if(adj[u][i] == 1){
                int vtx = i;
                if(dfs_number[vtx] == UNVISITED){

                    dfs_parent[vtx] = u;
                    if(u == dfs_root){
                        rootChildren++;
                    }

                    findArticulationVertices(vtx);

                    if(dfs_low[vtx] >= dfs_number[u]){
                        articulation_vertex[u] = true;
                    }
                    dfs_low[u] = Math.min(dfs_low[u], dfs_low[vtx]);

                }else if(vtx != dfs_parent[u]){
                    dfs_low[u] = Math.min(dfs_low[u], dfs_number[vtx]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){

            n = Integer.parseInt(sc.nextLine());
            if(n == 0){
                break;
            }

            n++;
            adj = new int[n][n];
            dfs_number = new int[n];
            dfs_parent = new int[n];
            dfs_low = new int[n];
            dfsNumCounter = 0;
            articulation_vertex = new boolean[n];
            Arrays.fill(dfs_number, UNVISITED);

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line);
                int src = Integer.parseInt(st.nextToken());
                if(src == 0){
                    break;
                }
                int des;
                while(st.hasMoreTokens()){
                    des = Integer.parseInt(st.nextToken());
                    adj[src][des] = 1;
                    adj[des][src] = 1;
                }
            }
                for(int i = 0; i < n; i++){
                    if(dfs_number[i] == UNVISITED){
                        dfs_root = i;
                        rootChildren = 0;
                        findArticulationVertices(dfs_root);
                        articulation_vertex[dfs_root] = (rootChildren > 1);
                    }
                }

                int count = 0;
                for(int i = 0; i < n; i++){
                    if(articulation_vertex[i]){
                        count++;
                    }
                }
                System.out.println(count);
            
        }
    }
}