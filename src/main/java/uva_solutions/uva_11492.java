package uva_solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class uva_11492{
    static int M;
    static int adj[][];
    static int INF = 1000000000;

    private static class Pair implements Comparable<Pair>{
        int id, dist;
        public Pair(int i, int d){
            this.id = i;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p){
            return this.dist - p.dist;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            M = sc.nextInt();
            if(M == 0){
                break;
            }
            String sLang, dLang;
            String[] word = new String[M+2];
            String[] lang1 = new String[M+2];
            String[] lang2 = new String[M+2];
            word[0] = "$";
            word[M+1] = "*";
            adj = new int[M+2][M+2];
            for(int i = 0; i < adj.length; i++){
                Arrays.fill(adj[i], INF);
            }
            
            sLang = sc.next(); dLang = sc.next();
            for(int i = 1; i <= M; i++){
                lang1[i] = sc.next();
                lang2[i] = sc.next();
                word[i] = sc.next();
            }
            //source
            for(int i = 1; i <= M; i++){
                if(lang1[i].equals(sLang) || lang2[i].equals(sLang)){
                    adj[0][i] = 0;
                }
            }
            //sink
            for(int i = 1; i <= M; i++){
                if(lang1[i].equals(dLang) || lang2[i].equals(dLang)){
                    adj[i][M+1] = word[i].length();
                }
            }
            //edges
            for(int i = 1; i <= M; i++){
                for(int j = 1; j <=M; j++){
                    if(i == j || word[i].charAt(0) == word[j].charAt(0)){
                        continue;
                    }

                    if(lang1[i].equals(lang1[j]) || lang1[i].equals(lang2[j])
                    || lang2[i].equals(lang1[j]) || lang2[i].equals(lang2[j])){
                        adj[i][j] = word[i].length();
                    }
                }
            }

            int src = 0, des = M+1;
            int[] dist = new int[M+2];
            
            Arrays.fill(dist, INF);
            dist[src] = 0;
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(src,0));
            while(!pq.isEmpty()){
                Pair top = pq.peek();
                pq.remove();
                if(top.dist > dist[top.id]){
                    continue;
                }
                for(int j = 0; j < adj[top.id].length;j++){
                    if(adj[top.id][j] != INF){
                        if(dist[top.id] + adj[top.id][j] < dist[j]){
                            dist[j] = dist[top.id] + adj[top.id][j];
                            pq.add(new Pair(j, dist[j]));
                        }
                    }
                }
            }

            if(dist[des] == INF){
                System.out.println("impossivel");
            }else{
                System.out.println(dist[des]);
            }

        }    
    }
}