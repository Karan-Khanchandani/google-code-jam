package uva_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class uva_01056{
    private static int n,r, INF = 1000000000;
    private static Map<String, Integer> map;
    private static Map<Integer, String> revMap;
    private static int[][] adj;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tno = 0;
        boolean first = true;
        while(sc.hasNext()){

            n = Integer.parseInt(sc.next()); 
            r = Integer.parseInt(sc.next());

            if(n == 0 && r == 0){
                break;
            }

            tno++; 
            adj = new int[n][n];
            map = new HashMap<>();
            revMap = new HashMap<>();
            for(int i = 0; i < n; i++){
                Arrays.fill(adj[i], INF);
                adj[i][i] = 0;
            }

            int g_id = 0;
            for(int i = 0,j = i+1; i < r; i++){
                String src = sc.next();
                String des = sc.next();
                int srcIdx, desIdx;

                if(map.containsKey(src)){
                    srcIdx = map.get(src);
                }else{
                    srcIdx = g_id++;
                    map.put(src, srcIdx);
                    revMap.put(srcIdx, src); 
                }

                if(map.containsKey(des)){
                    desIdx = map.get(des);
                }else{
                    desIdx = g_id++;
                    map.put(des, desIdx);
                    revMap.put(desIdx, des);
                }

                adj[srcIdx][desIdx] = 1;
                adj[desIdx][srcIdx] = 1;
               
            }

            for(int k = 0; k < n; k++){
                for(int i =0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }
            }

            boolean disconnected = false;
            int ans = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(adj[i][j] == INF){
                        disconnected = true;
                        break;
                    }else{
                        ans = Math.max(ans, adj[i][j]);
                    }
                }
            }

            if(disconnected){
                System.out.println("Network "+ tno + ": " + "DISCONNECTED");
            }else{
                System.out.println("Network "+ tno + ": " + ans);   
            }
            System.out.println();
        }
    }
}