package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_00462{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        sc.nextLine();
        for(int tno = 1; tno <= t; tno++){

            int time[] = new int[26];
            int adj[][] = new int[26][26];

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.equals("")){
                    break;
                }
                StringTokenizer st = new StringTokenizer(line);
                int src = Integer.parseInt(st.nextToken());
                int tm = Integer.parseInt(st.nextToken());
                time[src] = tm;
                String dess = st.hasMoreTokens() ? st.nextToken() : "";
                for(int j = 0; j < dess.length(); j++){
                    int des = Integer.parseInt(String.valueOf(dess.charAt(j)));
                    adj[src][des] = 1;
                }
            }

            
            
        }
    }
}