package uva_solutions;

import java.util.*;

public class uva_00908{

    private static class UnionFind{
        private int[] p, rank;

        public UnionFind(int n){
            p = new int[n+1];
            rank = new int[n+1];
            for(int i = 0; i <= n; i++){
                p[i] = i;
            }
        }

        int findSet(int i){
            return (p[i] == i) ? i : (p[i] = findSet(p[i]));
        }

        boolean isSameSet(int i, int j){
            return findSet(i) == findSet(j);
        }

        void unionSet(int i, int j){
            if(!isSameSet(i, j)){
                int x = findSet(i), y = findSet(j);
                if(rank[x] > rank[y]){
                    p[y] = x;
                }else{
                    p[x] = y;
                    if(rank[x] == rank[y]){
                        rank[y]++;
                    }
                }
            }
        }
    }

    private static List<Edge> EdgeList;
    private static class Edge{
        private int u,v,w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean first = true;
        while(sc.hasNextLine()){

            if(first){
                first = false;
            }else{
                sc.nextLine();
                System.out.println();
            }

            int n = Integer.parseInt(sc.nextLine());
            EdgeList = new ArrayList<>();
            int ans1 = 0;
            for(int i = 0; i < n -1 ; i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                st.nextToken();
                st.nextToken();
                ans1 += Integer.parseInt(st.nextToken());
            }

            int k = Integer.parseInt(sc.nextLine());
            for(int i = 0 ; i < k; i++){
                int u,v,w;
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                EdgeList.add(new Edge(u, v, w));
            }
            int m = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < m; i++){
                int u,v,w;
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                EdgeList.add(new Edge(u, v, w));
            }

            Collections.sort(EdgeList, new Comparator<Edge>(){
                @Override
                public int compare(Edge e1, Edge e2){
                    return e1.w - e2.w;
                }
            });

            int mst_cost = 0;
            UnionFind uf = new UnionFind(n);
            for(int i = 0; i < EdgeList.size(); i++){
                Edge e = EdgeList.get(i);
                if(!uf.isSameSet(e.u, e.v)){
                    mst_cost += e.w;
                    uf.unionSet(e.u, e.v);
                }
            }

            System.out.println(ans1);
            System.out.println(mst_cost);
        }
    }
}