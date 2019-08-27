package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10577{

    private static class Line{
        double a, b, c;
        public Line(Point p1, Point p2){
            if(p1.x == p2.x){
                a = 1.0;
                b = 0.0;
                c = -(p1.x);
            }else{
                a = -(p2.y - p1.y)/(p2.x - p1.x);
                b = 1.0;
                c = -a*p1.x - p1.y;
            }
        }
    }

    private static Point areIntersect(Line l1, Line l2){
        double x = (l2.b*l1.c - l1.b*l2.c)/(l2.a*l1.b - l1.a*l2.b),y;
        if(l1.b > 0){
            y = -(l1.a*x + l1.c);
        }else{
            y = -(l2.a*x  + l2.c);
        }

        return new Point(x, y);
    }
    
    private static class Point{
        private double x, y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    private static Point rotate(Point p, double theta) 
		{
			double c = Math.cos(theta), s = Math.sin(theta);
			return new Point(p.x * c - p.y * s, p.x * s + p.y * c); 
		}

    private static double dist(Point a, Point b){
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

  
    // private static Point rCircumCenter(Point[] pts){
    //     Line l1 = new Line(new Point(0.5*(pts[0].x + pts[1].x), 0.5*(pts[0].y + pts[1].y)), pts[2]);
    //     Line l2 = new Line(new Point(0.5*(pts[1].x + pts[2].x), 0.5*(pts[1].y + pts[2].y)), pts[0]);

    //     return areIntersect(l1, l2);
    // }

    static Point circumCircle(Point[] pts) 
	{
        Point a = pts[0], b = pts[1] , c = pts[2];
		double bax = b.x - a.x, bay = b.y - a.y;
		double cax = c.x - a.x, cay = c.y - a.y;

		double e = bax * (a.x + b.x) + bay * (a.y + b.y);
		double f = cax * (a.x + c.x) + cay * (a.y + c.y);
		double g = 2.0 * (bax * (c.y - b.y) - bay * (c.x - b.x));

		//if (Math.abs(g) < EPS) return null;

		return new Point((cay*e - bay*f) / g, (bax*f - cax*e) / g);

	}

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        int tno = 0;
        while(sc.hasNextLine()){
            n = Integer.parseInt(sc.nextLine());
            if(n == 0){
                break;
            }
            tno++;
            Point pts[] = new Point[3];
            for(int i = 0; i < 3; i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                pts[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            }

            //Point center = rCircumCenter(pts);
            Point center = circumCircle(pts);
            // System.out.println("Center " + center.x + " " + center.y);
            // System.out.println("Center " + center1.x + " " + center1.y);
            
            double rad = dist(pts[0], center);
            
            
            Point p = pts[0];
            double maxX = p.x, maxY =p.y;
            double minX = p.x, minY = p.y;

            double theta = 2*Math.PI/(double)n;
            for(int i = 1; i < n; i++){
                Point temp = new Point(p.x - center.x , p.y - center.y);
                temp = rotate(temp, theta);
                p = new Point(temp.x + center.x, temp.y + center.y);
                maxX = Math.max(maxX, p.x);
                maxY = Math.max(maxY,p.y);
                minX = Math.min(minY, p.x);
                minY = Math.min(minY,p.y);
            }

            double ans = (maxX - minX)*(maxY - minY);
            System.out.format("Polygon %s: %.3f\n",tno,ans);
        }
    }
}