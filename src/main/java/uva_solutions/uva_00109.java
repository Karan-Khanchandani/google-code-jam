package uva_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class uva_00109{
    static final double EPS = 1e-9;
    static class Point implements Comparable<Point>{
        int x, y;
        public Point(int a, int b){
            x = a;
            y = b;
        }

        @Override
        public int compareTo(Point p){
            if(x != p.x){
                return x - p.x;
            }
            return y - p.y;
        }
    }

    static class Vector{
        int x, y;

        public Vector(Point a, Point b){
            x = b.x - a.x;
            y = b.y - a.y;
        }

        int cross(Vector v){
            return x*v.y - y*v.x;
        }

        int dot(Vector v){
            return x*v.x + y*v.y;
        }

        double norm2(){
            return x*x + y*y;
        }

    }

    static boolean ccw(Point p, Point q, Point r){
        return (new Vector(p,q).cross(new Vector(p,r)) > 0);
    }

    static double angle(Point a, Point o, Point b){
        Vector oa = new Vector(o,a), ob = new Vector(o,b);
        return Math.acos(oa.dot(ob)/Math.sqrt(oa.norm2()*ob.norm2()));
    }

    static class Kingdom{
        Point[] g;
        boolean destroyed;

        public Kingdom(Point[] points){
            int n = points.length;
            g = new Point[n << 1];
            Arrays.sort(points);
            int size = 0, start = 0;
            
            for(int i = 0; i < n; i++){
                Point p = points[i];
                while(size - start >= 2 && !ccw(g[size - 2], g[size -1], p)) size--;
                g[size++] = p;
            }

            start = --size;

            for(int i = n-1; i >= 0; i--){
                Point p = points[i];
                while(size - start >= 2 && !ccw(g[size - 2], g[size -1], p)) size--;
                g[size++] = p;
            }

            g = Arrays.copyOf(g, size);
        }

        double area(){
            double ret = 0.0;
            for(int i =0; i < g.length -1; i++){
                ret += g[i].x*g[i+1].y - g[i+1].x*g[i].y;
            }
            return Math.abs(ret)/2.0;
        }

        boolean inside(Point p){
            double sum = 0.0;
            for(int i = 0; i < g.length - 1; i++){
                double angle = angle(g[i], p, g[i+1]);
                if(ccw(p, g[i], g[i+1]))
                    sum += angle;
                else
                    sum -= angle;
            }
            return Math.abs(sum - 2*Math.PI) < EPS;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Kingdom> k = new ArrayList<>(20);
        while(true){
            int n = sc.nextInt();
            if(n == -1){
                break;
            }

            Point[] sites = new Point[n];
            for(int i =0; i < n; i++){
                sites[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            k.add(new Kingdom(sites));
        }

        while(sc.hasNext())
		{
			Point missile = new Point(sc.nextInt(), sc.nextInt());
			for(int i = 0; i < k.size(); i++)
			{
				Kingdom cur = k.get(i);
				if(!cur.destroyed && cur.inside(missile))
					cur.destroyed = true;
			}
		}
		
		double ans = 0.0;
		for(int i = 0; i < k.size(); i++)
		{
			Kingdom cur = k.get(i);
			if(cur.destroyed)
				ans += cur.area();
		}
		System.out.printf("%.2f\n", ans);
    }
}