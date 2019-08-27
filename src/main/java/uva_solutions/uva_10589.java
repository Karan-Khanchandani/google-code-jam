package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10589{
    private static class Point{
        private double x , y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isOnOrInsideCircle(Point c, Point p, double rad){
        double dx = c.x - p.x;
        double dy = c.y - p.y;
        double euc = dx*dx + dy*dy;
        if(euc <= rad*rad){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int n;
        double rad;
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            n = Integer.parseInt(st.nextToken());
            rad = Double.parseDouble(st.nextToken());
            if(n == 0){
                break;
            }
            int m_count = 0;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(sc.nextLine());
                double x, y;
                x = Double.parseDouble(st.nextToken());
                y = Double.parseDouble(st.nextToken());

                if(x*x + y*y <= rad*rad && (x-rad)*(x-rad) + y*y <= rad*rad 
                && (x-rad)*(x-rad) + (y-rad)*(y-rad) <= rad*rad  && x*x + (y-rad)*(y-rad) <= rad*rad){
                    m_count++;
                }
            }

            double ans = (double)m_count*rad*rad;
            ans /= (double)n;

            System.out.format("%.5f\n",ans);
        }
    }
}