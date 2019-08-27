package uva_solutions;

import java.util.*;

public class uva_00429{
    private static Map<String, Integer> map;
    private static Map<Integer, String> revMap;
    private static boolean[][] adj;


    private static boolean diffCheck(String src, String des){
        if(src.length() != des.length()){
            return false;
        }

        int diffCount = 0;
        for(int i = 0; i < src.length(); i++){
            if(src.charAt(i) != des.charAt(i)){
                diffCount++;
            }
        }

        return diffCount == 1;
    }
    private static void initGraph(){
        for(int i = 0; i < adj.length; i++){
            for(int j = i+1; j < adj.length; j++){
                if(diffCheck(revMap.get(i), revMap.get(j))){
                    adj[i][j] = true;
                    adj[j][i] = true;
                }
            }
        }
    }

    private static int findSSSP(String s, String d){
        int dist[] = new int[adj.length];
        Arrays.fill(dist, 1000000000);
        Queue<Integer> q = new LinkedList<>();
        dist[map.get(s)] = 0;
        q.add(map.get(s));
        while(!q.isEmpty()){
            int u = q.peek();
            q.remove();
            for(int i = 0; i < adj[u].length; i++){
                if(adj[u][i]){
                    int v = i;
                    if(dist[v] == 1000000000){
                        dist[v] = dist[u] + 1;
                        q.add(v);
                    }
                }
            }
        }

        return dist[map.get(d)];

    }

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        boolean first = true;
        sc.nextLine(); // blank line
        for(int tno = 1; tno <= t; tno++){
            while(sc.hasNextLine()){
                if(first){
                    first = false;
                }else{
                    System.out.println();
                    //sc.nextLine(); // blank line
                }
                String line;
                map = new HashMap<>();
                revMap = new HashMap<>();
                int i = 0;
                while(sc.hasNextLine()){
                    line = sc.nextLine();
                    if(line.equals("*")){
                        break;
                    }

                    map.put(line, i);
                    revMap.put(i, line);
                    i++;
                }

                int n = i;
                adj = new boolean[n][n];
                for(i = 0; i < n; i++){
                    adj[i] = new boolean[n];
                }

                //process graph
                initGraph();

                while(sc.hasNextLine()){
                    line = sc.nextLine();
                    if(line.equals("")){
                        break;
                    }
                    StringTokenizer st = new StringTokenizer(line);
                    String src = st.nextToken();
                    String des = st.nextToken();
                    System.out.println(src + " " + des + " "  + findSSSP(src, des));
                }
            }
        }
         
    }
}