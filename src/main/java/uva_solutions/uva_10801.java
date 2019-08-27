package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10801{
    private static int cost[][];
    private static boolean visited[][];
    private static int adj[][];
    private static int speed[];
    private static int n,k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            adj = new int[100][5];
            cost = new int[100][100];
            visited = new boolean[100][5];

            

            StringTokenizer st = new StringTokenizer(sc.nextLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            speed = new int[n];

            for(int i = 0; i < 100; i++){           
                    for(int j = 0; j < n; j++){
                        adj[i][j] = 60;
                }           
            }

            st = new StringTokenizer(sc.nextLine());
            for(int i = 0; i < n; i++){
                speed[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(sc.nextLine());
            }

            int ans = solve();
            if(ans == -1){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(ans);
            }
        }
    }
}