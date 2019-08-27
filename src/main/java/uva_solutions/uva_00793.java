package uva_solutions;

import java.util.Scanner;

public class uva_00793{

    public static class UnionFind{
        public int rank[], p[];

        public UnionFind(int n){
            rank = new int[n+1];
            p = new int[n+1];
            for(int i = 0; i <=n ; i++){
                p[i] = i;
            }
        }

        public void union(int i, int j){
            if(!isSameSet(i, j)){
               int x = findSet(i);
               int y = findSet(j);
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

        public int findSet(int i){
            return (p[i] == i) ? i : (p[i] = findSet(p[i]));
        }

        public boolean isSameSet(int i, int j){
            return findSet(i) == findSet(j);
        }

    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = Integer.parseInt(sc.nextLine());
       sc.nextLine();
       for(int tno = 1; tno <= t; tno++){
        
        int n_comp = Integer.parseInt(sc.nextLine());
       
        UnionFind uf = new UnionFind(n_comp);
        int succ = 0, unsucc = 0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("")){
                break;
            }
            Character c = line.charAt(0);
            String[] inp = line.split(" ");
           // Character c = line.charAt(0);
            int comp1 = Integer.parseInt(inp[1]);
            int comp2 = Integer.parseInt(inp[2]);
            if(c == 'c'){
                uf.union(comp1, comp2);
            }else{
                if(uf.isSameSet(comp1, comp2)){
                    succ++;
                }else{
                    unsucc++;
                }
            }
        }    
        if(tno  == 1){
            System.out.println(succ + "," + unsucc);
        }else{
            System.out.println();
            System.out.println(succ + "," + unsucc);
        } 
       } 
    }
}