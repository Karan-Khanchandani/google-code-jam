package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10005{

    private static class Point{
        private double x, y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean circle2PtsRad(Point p1, Point p2, double r){
        double d2 = (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y);
        double det = r*r/d2 - 0.25;
        if(det < 0.0){
            return false;
        }
        return true;
    }
    private static double dist(Point p1, Point p2){
        return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNextLine()){
            n = Integer.parseInt(sc.nextLine());
            if(n == 0){
                break;
            }

            Point points[] = new Point[n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            }

            Double rad = Double.parseDouble(sc.nextLine());
            boolean flag = true;
            double maxDist = 0;
            Point centre = new Point(-1, -1);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                   if(dist(points[i], points[j]) > maxDist){
                       maxDist = dist(points[i], points[j]);
                       centre.x = (points[i].x + points[j].x)*0.5;
                       centre.y = (points[i].y + points[j].y)*0.5;
                   }
                }
            }

            for(int i = 0; i < n; i++){
                if(dist(centre, points[i]) > rad){
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println("The polygon can be packed in the circle.");
            }else{
                System.out.println("There is no way of packing that polygon.");
            }
        }
    }
}