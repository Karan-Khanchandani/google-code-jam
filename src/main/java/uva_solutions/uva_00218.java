package uva_solutions;

import java.util.Arrays;
import java.util.Scanner;


public class uva_00218{
    static final double EPS = 1e-9;
    static class Point implements Comparable<Point>{
        double x, y;
        public Point(double a, double b){
            x = a;
            y = b;
        }

        @Override
        public int compareTo(Point a){
            if(Math.abs(x - a.x) > EPS){
                return Double.compare(x, a.x);
            }
            return Double.compare(y, a.y);
        }
    }

    static class Vector{
        double x, y;
        public Vector(Point a, Point b){
            x = b.x - a.x;
            y = b.y - a.y;
        }

        double cross(Vector v){
            return x*v.y - y*v.x;
        }

        double dot(Vector v){
            return x*v.x + y*v.y;
        }

        double norm2(){
            return x*x + y*y;
        }
    }

    static boolean ccw(Point p, Point q, Point r){
        Vector pq = new Vector(p,q);
        Vector pr = new Vector(p,r);
        return (pq.cross(pr) >= 0);
    }

    static double dist(Point a, Point b){
        return Math.hypot(a.x - b.x, a.y - b.y);
    }


    public static void main(String[] args) {
        int n;
        int tno = 0;
        Scanner sc = new Scanner(System.in);
        boolean first = true;
        while(sc.hasNext()){
            n = sc.nextInt();
            if(n == 0){
                break;
            }
            tno++;
            if(first){
                first = false;
            }else{
                System.out.println();
            }
            Point[] points = new Point[n];
            for(int i = 0; i < n; i++){
                points[i] = new Point(sc.nextDouble(),sc.nextDouble());
            }

            Arrays.sort(points);
            Point[] g = new Point[n << 1];
            int size = 0;
            for(int i = 0;i < n; i++){
                Point p = points[i];
                while(size>= 2 && (ccw(g[size - 2], g[size - 1], p))) size--;
                g[size++] = p;
            }
            
            for(int i = n-1, j= size + 1;i >= 0; i--){
                Point p = points[i];
                while(size >= j && (ccw(g[size - 2], g[size - 1], p))) size--;
                g[size++] = p;
            }
            g = Arrays.copyOf(g, size);
            System.out.println("Region #"+tno+":");
            for(int i = 0; i < g.length; i++){
                if(i!=0){
                    System.out.print("-");
                }
                System.out.format("(%.1f,%.1f)", g[i].x, g[i].y);
            }
            System.out.println();
            double peri = 0.0;
            for(int i = 0; i < g.length; i++){
                peri += (i == g.length - 1) ? dist(g[i],g[0]) : dist(g[i],g[i+1]);
            }
            System.out.format("Perimeter length = %.2f\n", peri);
        }
    }
}