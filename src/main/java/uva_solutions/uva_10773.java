package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;


public class uva_10773{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int d, v, u;
            d = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            u = Integer.parseInt(st.nextToken());
            String ans = "";
            if(v == 0 || u == 0 || v >= u){
                ans = "can't determine";
            }else{
                double v1 = (double) v;
                double d1 = (double) d;
                double u1 = (double) u;
                double theta = Math.acos(v1/u1);
                double againstRiver = d1/(u1*Math.sin(theta));
                double withRiver = d1/u1;
                double an = againstRiver - withRiver;
                ans = String.format("%.3f", an);
            }
            System.out.println("Case " + tno + ": " + ans);
        }
    }
}