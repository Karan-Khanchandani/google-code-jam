package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10583{

    private static class DisjointSet{
        private int[] parent, rank, size;
        private int arraySize;

        public DisjointSet(int n){
            arraySize = n;
            parent = new int[arraySize+1];
            rank = new int[arraySize+1];
            size = new int[arraySize + 1];

            for(int i = 0; i < arraySize; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            return (parent[x] == x) ? x: (parent[x] = find(parent[x]));
        }

        public void union(int x, int y){
            int px = find(x);
            int py = find(y);

            if(px != py){
                if(rank[px] > rank[py]){
                    size[px] += size[py];
                    size[py] = 0;
                    parent[py] = px;
                }else{
                    size[py] += size[px];
                    size[px] = 0;
                    parent[px] = py;
                }

                if(rank[px] == rank[py]){
                    rank[py]++;
                }
            }
        }

        public int num_disj_sets(){
           int ans = 0;
            for(int i = 0 ; i < arraySize; i++){
               if(size[i] > 0) {
                   ans++;
               }
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseno = 0;
        while(sc.hasNextLine()){
            int n,m;
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }
            caseno++;
            DisjointSet ds = new DisjointSet(n);
            for(int i = 0; i < m; i++){
                String input = sc.nextLine();
                StringTokenizer st1 = new StringTokenizer(input);
                 int one = Integer.parseInt(st1.nextToken());
                 int two = Integer.parseInt(st1.nextToken());
                 ds.union(one, two);
            }

           System.out.println("Case " + caseno + ": "+ ds.num_disj_sets());
        }    
    }
}