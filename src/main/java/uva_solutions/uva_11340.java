package uva_solutions;

import java.util.Scanner;

public class uva_11340{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 0;
        t = Integer.parseInt(sc.nextLine());
       
        for(int tno = 1; tno <= t; tno++){
            int k;
            k = Integer.parseInt(sc.nextLine());
           
            int tableSize = 0xFF;
            int[] map = new int[tableSize];
            for(int i = 0; i < k; i++){
                String line = sc.nextLine();
                Character c = line.charAt(0);
                String[] inp = line.split(" ");
                int inte = Integer.parseInt(inp[1]);
               
                map[c] = inte;
            }
    
            int m;
            m =Integer.parseInt(sc.nextLine());
           
            int ans = 0;
            for(int i = 0; i < m; i++){
                String str = sc.nextLine();
               
                for(int j = 0; j < str.length(); j++){
                    Character c = str.charAt(j);
                   ans += map[c];
                }
            }
    
            System.out.format("%.2f$\n", ans/100.0);
        } 
    }
    
}