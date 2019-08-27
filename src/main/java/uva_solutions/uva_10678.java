package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10678{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        double PI = Math.acos(-1.0);
        for(int tno = 1; tno <=t ; tno++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            double d, n;
            d = Double.parseDouble(st.nextToken());
            n = Double.parseDouble(st.nextToken());

            double a = n*0.5;
            double b = Math.sqrt(a*a - d*d*0.25);
            System.out.format("%.3f\n", PI*a*b);
           }
    }
}