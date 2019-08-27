package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10170{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            double s = Double.parseDouble(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            double id  = d;
            id += s*(s-1)/2;
            double ans = Math.ceil((Math.sqrt(1 + 8*id) - 1)/2.0);
            int a = (int) ans;
            System.out.println(a);
        }
    }
}