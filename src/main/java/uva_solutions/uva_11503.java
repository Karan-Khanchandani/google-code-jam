package uva_solutions;

import java.util.*;

public class uva_11503{
    private static class DisjointSet{
        private Map<String, Integer> map;
        private Map<Integer, Integer> friends;
        private int total;
        private List<Integer> parent, rank;

        public DisjointSet(){
            map = new HashMap<>();
            friends = new HashMap<>();
            total = 0;
            parent = new ArrayList<>();
            rank = new ArrayList<>();
        }

        public void makeSet(String s){
            if(!map.containsKey(s)){
                map.put(s, total);
                friends.put(total, 1);
                parent.add(total);
                rank.add(0);
                total++;

            }
        }

        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px != py){
                int totalFriend = friends.get(px) + friends.get(py);
                friends.put(px, totalFriend);
                friends.put(py, totalFriend);
            }

            if(rank.get(px) > rank.get(py)){
                parent.set(py, px);
            }else{
                parent.set(px, py);
            }

            if(rank.get(py) == rank.get(px)){
                rank.set(py, rank.get(py) + 1);
            }
        }

        public int find(int x){
            if(x == parent.get(x)){
                return x;
            }else{
                parent.set(x, find(parent.get(x)));
                return parent.get(x);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for(int tno = 1; tno <=t ; tno++){
            int f = Integer.parseInt(sc.nextLine());
            DisjointSet ds = new DisjointSet();
            for(int j = 0; j < f; j++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                String fr1 = st.nextToken();
                String fr2 = st.nextToken();
                ds.makeSet(fr1);
                ds.makeSet(fr2);
                ds.union(ds.map.get(fr1), ds.map.get(fr2));
                System.out.println(ds.friends.get(ds.find(ds.map.get(fr1))));
            }
        }
    }
}