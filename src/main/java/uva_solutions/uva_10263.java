package uva_solutions;

import java.util.Scanner;

public class uva_10263{
    private static class Point{
        private double x, y;

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    private static class Vector{
        private double x, y;
        public Vector(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    private static Vector toVec(Point p1, Point p2){
        return new Vector(p2.x - p1.x, p2.y - p1.y);
    }

    private static Vector scale(Vector v, double s){
        return new Vector(v.x*s, v.y*s);
    }

    private static Point translate(Point p, Vector v){
        return new Point(p.x + v.x, p.y + v.y);
    }

    private static double dot(Vector a, Vector b){
        return (a.x*b.x + a.y*b.y);
    }

    private static double norm_sq(Vector v){
        return v.x*v.x + v.y*v.y;
    }

    private static double dist(Point a, Point b){
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    private static double distToLine(Point p, Point a, Point b, Point c[]){
        Vector ab = toVec(a,b), ap = toVec(a, p);
        double u = dot(ap, ab)/norm_sq(ab);
        c[0] = translate(a, scale(ab, u));
        return dist(p, c[0]);
    }

    private static double distanceToLineSeg(Point p, Point a, Point b, Point c[]){
        Vector ab = toVec(a,b), ap = toVec(a, p);
        double u = dot(ap, ab)/norm_sq(ab);
        if(u < 0.0){
            c[0] = new Point(a.x , a.y);
            return dist(a, p);
        }
        if(u > 1.0){
            c[0] = new Point(b.x, b.y);
            return dist(b, p);
        }
        return distToLine(p, a, b, c);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){

            Point m = new Point(Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            int n = Integer.parseInt(sc.nextLine());

            Point[] points = new Point[n+1];
            for(int i = 0; i <= n; i++){
                points[i] = new Point(Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            }
            
            double min = Double.MAX_VALUE;
            Point globalRes = new Point(0,0);
            for(int i = 0; i<n; i++){
                Point localRes[] = new Point[1];
                localRes[0] = new Point(0, 0);
                double temp = distanceToLineSeg(m, points[i], points[i+1],localRes);
                if(temp < min){
                    min = temp;
                   globalRes = new Point(localRes[0].x, localRes[0].y);
                }
                localRes = null;

            }

            System.out.format("%.4f\n", globalRes.x);
            System.out.format("%.4f\n", globalRes.y);
        }
    }
}