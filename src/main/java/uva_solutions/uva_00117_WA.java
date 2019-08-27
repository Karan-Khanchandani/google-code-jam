package uva_solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class uva_00117{
    static class Edge{
        int to, cost;
        boolean used;
        public Edge(int t, int c, boolean u){
            to = t;
            cost = c;
            used = u;
        }
    }
    static ArrayList<Edge>[] adjList;
    static ArrayList<Integer> cyc;
    static int[] degree;
    static int[][] adjMat;
    static void EulerTour(ArrayList<Integer> cycle, int u){
        for(int  j = 0; j < adjList[u].size(); j++){
            Edge v = adjList[u].get(j);
            if(!v.used){
                v.used = true;
                for(int k = 0; k < adjList[v.to].size(); k++){
                    Edge uu = adjList[v.to].get(k);
                    if(uu.to == u && !uu.used){
                        uu.used = true;
                        break;
                    }
                }
                cycle.add(u);
                EulerTour(cycle, v.to);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            adjList = new ArrayList[26];
            adjMat = new int[26][26];
            degree = new int[26];
            cyc = new ArrayList<Integer>();
            String line;
            while(!(line = sc.nextLine()).equals("deadend")){
                int src = (int) line.charAt(0) - 'a';
                int des = (int) line.charAt(line.length() - 1) - 'a';
                int cost = line.length();
                if(adjList[src] == null) adjList[src] = new ArrayList<Edge>();
                if(adjList[des] == null) adjList[des] = new ArrayList<Edge>();
                adjList[src].add(new Edge(des, cost, false));
                adjList[des].add(new Edge(src, cost, false));
                adjMat[src][des] = cost;
                adjMat[des][src] = cost;
                degree[src]++;
                degree[des]++;
            }
            cyc.clear();
            boolean odd = false;
            for(int i = 0; i < 26; i++){
              
                if(degree[i]%2 == 1){
                    odd = true;
                    EulerTour(cyc, i);
                    break;
                }
            }
            if(!odd){
                for(int i = 0; i < 26; i++){
                
                    if(degree[i] > 0){
                        EulerTour(cyc, i);
                        break;
                    }
                } 
            }
           
            int ans = 0;
            System.out.print(cyc.get(0) + " ");
            for(int i = 1; i < cyc.size(); i++){
                System.out.print(cyc.get(i) + " ");
                int from = cyc.get(i);
                int to = cyc.get(i - 1);
                ans += adjMat[from][to];
            }
            System.out.println();
            int from = cyc.get(cyc.size() - 1);
            int to = cyc.get(0);
            ans += adjMat[from][to];
            System.out.println(ans);
        }
    }
}