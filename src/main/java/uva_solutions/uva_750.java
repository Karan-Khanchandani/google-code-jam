package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_750{
    private static int[] row;
    private static int ROW ,COL;
    private static boolean[] ld, rd, rw;

    private static void backtrack(int[] row, int c, int ROW, int COL){
        if(c == 8){
            return;
        }else{
            for(int r = 0; r < 8 ; r++){

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        sc.nextLine();
        for(int tno = 1; tno <= t; tno++){
            row = new int[8];
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            ROW = Integer.parseInt(st.nextToken()) - 1;
            COL = Integer.parseInt(st.nextToken()) - 1;

            backtrack(0);
            if(tno != 1){
                System.out.println();
            }
        }
   }
}