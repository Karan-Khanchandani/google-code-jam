package uva_solutions;

import java.util.*;

public class uva_11060{
    private static List<List<Integer>> adj;
    private static int GRAPH_SIZE;
    private static Map<String, Integer> bev;
    private static Map<Integer, String> revBev;
    private static int indegree[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean first = true;
        int tno = 0;

        while(sc.hasNextLine()){

            if(first){
                first = false;
            }else{
                System.out.println();
                sc.nextLine();
            }

            int n = Integer.parseInt(sc.nextLine());
            bev = new HashMap<>();
            revBev = new HashMap<>();
            adj = new ArrayList<>();

            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
                String drink = sc.nextLine();
                bev.put(drink, i);
                revBev.put(i, drink);
            }
            indegree = new int[n];
            int m =  Integer.parseInt(sc.nextLine());
            StringTokenizer st;
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(sc.nextLine());
                String src = st.nextToken();
                int srcIdx = bev.get(src);
                String des = st.nextToken();
                int desIdx = bev.get(des);
                boolean isPresent = false;
                for(int j = 0; j < adj.get(srcIdx).size(); j++){
                    if(adj.get(srcIdx).get(j) == desIdx){
                        isPresent = true;
                        break;
                    }
                }
                if(!isPresent){
                    adj.get(srcIdx).add(desIdx);
                    indegree[desIdx]++;
                }
               
            }

            Deque<Integer> queue = new LinkedList<>();

            for(int i = 0; i < n; i++){
                
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
           
    
            List<Integer> ans = new ArrayList<>();
            while(!queue.isEmpty()){
                Integer vertex = queue.removeFirst();
                ans.add(vertex);
                for(int i = 0; i < adj.get(vertex).size(); i++){
                    indegree[adj.get(vertex).get(i)]--;
                    if(indegree[adj.get(vertex).get(i)] == 0){
                        queue.addFirst(adj.get(vertex).get(i));
                    }
                }
            }
            tno++;
            
            System.out.print("Case "+ tno+": Dilbert should drink beverages in this order:");
            for(int i = 0; i < ans.size(); i++){
                System.out.print(" " + revBev.get(ans.get(i)));
            }
            System.out.print(".");
            System.out.println();
    
        }
    }
}