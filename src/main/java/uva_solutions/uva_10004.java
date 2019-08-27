package uva_solutions;

import java.util.*;

public class uva_10004{
    private static int[][] adj;
    private static int n;
    

    private static boolean isBiColor(int num){
         int color[] = new int[n];
         Arrays.fill(color, Integer.MAX_VALUE);
        boolean isBipartite = true;
        color[num] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while(!q.isEmpty() && isBipartite){
            Integer vtx = q.remove();
            for(int i = 0; i < adj[vtx].length; i++){
                if(adj[vtx][i] == 1){
                    if(color[i] == Integer.MAX_VALUE){
                        color[i] = 1 - color[vtx];
                        q.add(i);
                    }else{
                        if(color[i] == color[vtx]){
                            isBipartite = false;
                            break;
                        }
                    }
                }
            }
        }

        return isBipartite;
        
    }
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            n = Integer.parseInt(sc.nextLine());
            if(n == 0){
                break;
            }
            adj = new int[n][n];
            for(int i = 0; i < n; i++){
                adj[i] = new int[n];
            }
            int m = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < m; i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                int src = Integer.parseInt(st.nextToken());
                int des = Integer.parseInt(st.nextToken());
                adj[src][des] = 1;
                adj[des][src] = 1;
            }

            if(isBiColor(0)){
                System.out.println("BICOLORABLE.");
            }else{
                System.out.println("NOT BICOLORABLE.");
            }
        }
    }
}