package uva_solutions;

import java.util.*;

public class uva_10986{
    private static int N,M;
    private static int[][] adj;
    private static final int INF = Integer.MAX_VALUE;

    private static class Pair{
        int x, weight;
        public Pair(int x, int w){
            this.x = x;
            this.weight = w;
        }  

     }

    private static int findSSSP(int s, int d){
        int dist[] = new int[N];
        Arrays.fill(dist, INF);

        dist[s] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(N*N, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.weight - p2.weight;
            }
        });
        pq.add(new Pair(s, 0));
        while(!pq.isEmpty()){
            Pair u = pq.peek();
            pq.remove();
            if(u.x == d){
                break;
            }
            if(u.weight > dist[u.x]){
                continue;
            }

            for(int j = 0; j < N; j++){
                if(adj[u.x][j] != -1){
                    if(dist[u.x] + adj[u.x][j] < dist[j]){
                        dist[j] = dist[u.x] + adj[u.x][j];
                        pq.add(new Pair(j, dist[j]));
                    }
                }
            }
        }

        return dist[d];

    }
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            int s, d;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            adj = new int[N][N];
            
            for(int i = 0; i < N; i++){
                adj[i] = new int[N];
                Arrays.fill(adj[i], -1);
            }
            for(int i = 0; i< M; i++){
                st = new StringTokenizer(sc.nextLine());
                int src = Integer.parseInt(st.nextToken());
                int des = Integer.parseInt(st.nextToken());
                int lat = Integer.parseInt(st.nextToken());
                adj[src][des] = lat;
                adj[des][src] = lat;
            }

            int ans = findSSSP(s,d);
            if(ans == INF){
                System.out.println("Case #" + tno + ": " + "unreachable");
            }else{
                System.out.println("Case #" + tno + ": " + ans);
            }
            
        }
    }
}