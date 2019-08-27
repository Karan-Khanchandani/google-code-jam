package uva_solutions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10308{
    static class Edge{
        int to,  cost;
        public Edge(int t, int c){
            to = t;
            cost = c;
        }
    }
    static ArrayList<Edge>[] adjList;
    static int maxDistance, maxNode;

    static void addEdge(int u, int v, int w){
        if(adjList[u] == null )
            adjList[u] = new ArrayList<Edge>();
        if(adjList[v] == null )
            adjList[v] = new ArrayList<Edge>();
        adjList[u].add(new Edge(v, w));
        adjList[v].add(new Edge(u, w));
    }

    static void dfs(int u, int p, int dist){
        if(dist > maxDistance){
            maxDistance = dist;
            maxNode = u;
        }
        for(int i = 0; i < adjList[u].size(); ++i)
		{
			Edge nxt = adjList[u].get(i);
			if(nxt.to == p)
				continue;
			dfs(nxt.to, u, dist + nxt.cost);
		}
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
           
            adjList = new ArrayList[10000];
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.equals("")) break;
                StringTokenizer st = new StringTokenizer(line);
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                int w = Integer.parseInt(st.nextToken());
                addEdge(u, v, w);
            }

            if(adjList[0] == null)
			{
				System.out.println(0);
				continue;
			}
            maxDistance = maxNode = -1;
            dfs(0, -1, 0);
            int node = maxNode;
			maxDistance = maxNode = -1;
            dfs(node, -1, 0);
            
            System.out.println(maxDistance);
        }

        sc.close();
        System.exit(0);
    }
}
