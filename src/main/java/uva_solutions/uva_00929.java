package uva_solutions;

import java.util.*;

public class uva_00929{
    private static int N,M, INF = 1000000000;
    private static int adj[][];
    private static int dist[][];
    
    private static class Pair{
        int dist, x, y;
        public Pair(int d, int x, int y){
            this.dist = d;
            this.x = x;
            this.y = y;
        }
    }

    private static int dr[] = {0,0,1,-1};
    private static int dc[] = {1,-1,0,0};
    private static int ans(){
        PriorityQueue<Pair> q = new PriorityQueue<>(N*M, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.dist - p2.dist;
            }
        });
        dist[0][0] = adj[0][0];
        q.add(new Pair(dist[0][0],0,0));
        while(!q.isEmpty()){
            Pair p = q.remove();

            if(p.dist > dist[p.x][p.y]){
                continue;
            }

            for(int i = 0; i < 4; i++){
                int tempX = p.x + dr[i];
                int tempY = p.y + dc[i];
                if(tempX >= 0 && tempX < N && tempY >= 0 && tempY < M){
                    
                    if(dist[tempX][tempY] > dist[p.x][p.y] + adj[tempX][tempY]){
                        dist[tempX][tempY] = dist[p.x][p.y] + adj[tempX][tempY];
                        q.add(new Pair(dist[tempX][tempY], tempX, tempY));
                    }
                }
            }
        }
        return dist[N-1][M-1];
    }

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t ; tno++){
            N = Integer.parseInt(sc.nextLine());
            M = Integer.parseInt(sc.nextLine());
            adj = new int[N][M];
            dist = new int[N][M];
            for(int i = 0 ; i < N; i++){
                adj[i] = new int[M];
                dist[i] = new int[M];
                Arrays.fill(dist[i], INF);
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line);
                for(int j = 0; j < M; j++){
                    adj[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(ans());
        }
    }
}