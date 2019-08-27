package uva_solutions;

import java.util.*;

public class uva_10171{
    private static int adj1[][], adj2[][];
    private static int n, INF = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){

            n = Integer.parseInt(sc.nextLine());

            if(n == 0){
                break;
            }

            adj1 = new int[26][26];
            adj2 = new int[26][26];

            StringTokenizer st;
            for(int i = 0; i < 26; i++){
                adj1[i] = new int[26];
                Arrays.fill(adj1[i], INF);
                adj1[i][i] = 0;
                adj2[i] = new int[26];
                Arrays.fill(adj2[i], INF);
                adj2[i][i] = 0;
            }

            for(int i = 0; i < n; i++){

                String line = sc.nextLine();
                 st = new StringTokenizer(line);

                if(st.nextToken().charAt(0) == 'Y'){
                    if(st.nextToken().charAt(0) == 'U'){
                        int src = st.nextToken().charAt(0) - 'A';
                        int des = st.nextToken().charAt(0) - 'A';
                        int val = Integer.parseInt(st.nextToken());
                        adj1[src][des] = Math.min(val, adj1[src][des]);
                    }else{
                        int src = st.nextToken().charAt(0) - 'A';
                        int des = st.nextToken().charAt(0) - 'A';
                        int val = Integer.parseInt(st.nextToken());
                        adj1[src][des] = Math.min(val, adj1[src][des]);
                        adj1[des][src] = Math.min(val, adj1[des][src]);
                    }
                }else{
                    if(st.nextToken().charAt(0) == 'U'){
                        int src = st.nextToken().charAt(0) - 'A';
                        int des = st.nextToken().charAt(0) - 'A';
                        int val = Integer.parseInt(st.nextToken());
                        adj2[src][des] = Math.min(val, adj2[src][des]);
                    }else{
                        int src = st.nextToken().charAt(0) - 'A';
                        int des = st.nextToken().charAt(0) - 'A';
                        int val = Integer.parseInt(st.nextToken());
                        adj2[src][des] = Math.min(val, adj2[src][des]);
                        adj2[des][src] = Math.min(val, adj2[des][src]);
                    }
                }
            }

            for(int k = 0; k < 26;k++){
                for(int i = 0; i < 26; i++){
                    for(int j = 0; j < 26; j++){
                        adj1[i][j] = Math.min(adj1[i][j], adj1[i][k] + adj1[k][j]);
                    }
                }
            }

            for(int k = 0; k < 26;k++){
                for(int i = 0; i < 26; i++){
                    for(int j = 0; j < 26; j++){
                        adj2[i][j] = Math.min(adj2[i][j], adj2[i][k] + adj2[k][j]);
                    }
                }
            }

            st = new StringTokenizer(sc.nextLine());
            int src = st.nextToken().charAt(0) - 'A';
            int src1 =st.nextToken().charAt(0) - 'A';
            
            int ans = INF;

            List<Character> res = new ArrayList<>();

            for(int i = 0; i < 26; i++){
                    if(ans > adj1[src][i] + adj2[src1][i]){
                        ans = adj1[src][i] + adj2[src1][i];
                        res.clear();
                        char c = (char)('A' + i);
                        res.add(c);
                    }else if(ans ==  adj1[src][i] + adj2[src1][i]){
                        char c = (char)('A' + i);
                        res.add(c);
                    }
                }
            
            if(ans == INF){
                System.out.println("You will never meet.");
            }else{
                System.out.print(ans);
                for(int i = 0; i < res.size(); i++){
                    System.out.print(" " + res.get(i));
                }
                System.out.println();
            }

        }
    }
}