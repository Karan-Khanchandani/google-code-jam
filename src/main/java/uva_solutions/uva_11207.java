package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11207{
    public static double calc(double l, double w){
       double size = 0;
       size = Math.max(size, Math.min(l, w/4));
       size = Math.max(size, Math.min(l/4, w));
       size = Math.max(size, Math.min(l/2, w/2));
       return size;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            if(n == 0){
                break;
            }
            double max = 0;
            int  idx = 1;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                double l = Double.parseDouble(st.nextToken());
                double w = Double.parseDouble(st.nextToken());

                double res = calc(Math.max(l,w), Math.min(l,w));
                if(res > max){
                    max = res;
                    idx = i + 1;
                }
            }

            System.out.println(idx);
        }
    }
}