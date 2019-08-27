package uva_solutions;

import java.util.Arrays;
import java.util.Scanner;

public class uva_11626{
    static class Point implements Comparable<Point>{
        int x,  y;
        public Point(int a, int b){
            x = a; y= b;
        }

        @Override
        public int compareTo(Point p){
            if(x != p.x)
                return x - p.x;
            return y - p.y;
        }
    }

    static class Vector{
        int x,  y;
        public Vector(Point a, Point b){
            x = b.x-a.x; y = b.y - a.y;
        }

        int cross(Vector v){
            return x*v.y - y*v.x;
        }

        int dot(Vector v){
            return x*v.x + y*v.y;
        }


    }

    static boolean ccw(Point p, Point q, Point r){
        return (new Vector(p,q).cross(new Vector(p, r)) >= 0);
    }

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        boolean first = true;
        for(int tno = 1; tno <= t; tno++){
            int n = sc.nextInt();
            Point[] points = new Point[n];
            for(int i = 0; i < n; i++){
                int x = sc.nextInt(), y = sc.nextInt();
                char c = sc.next().charAt(0);
                points[i] = new Point(x, y);
            }
           
            Arrays.sort(points);
            Point[] g = new Point[n << 1];
            int size = 0;
            for(int j = 0; j < n; j++){
                Point p = points[j];
                while(size >= 2 && !(ccw(g[size -2], g[size -1], p))) size--;
                g[size++] = p;
            }

            for(int j = n-2, k = size+1; j>=0; j-- ){
                Point p = points[j];
                while(size >= k && !(ccw(g[size -2], g[size -1], p))) size--;
                g[size++] = p;
            }

            g = Arrays.copyOf(g, size);
            System.out.println(g.length - 1);
            for(int i = 0; i < g.length - 1; i++){
                System.out.println(g[i].x + " " + g[i].y);
            }
        }
    }
}