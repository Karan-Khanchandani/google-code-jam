package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_00378{

    public static class Point{
        public double x, y;

        public Point(double _x, double _y){
            this.x = _x;
            this.y = _y;
        }
    }
    public static class Line{
        public double a, b, c;
        public Line(Point p1, Point p2){
            if(p1.x == p2.x){
                a = 1.0; b = 0.0; c = -p1.x; 
            }else{
                a = -(double)(p1.y - p2.y)/(p1.x - p2.x);
                b = 1.0;
                c = -(double)(a*p1.x) - p1.y;
            }
        }

        
    }

    public static boolean areParallel(Line l1, Line l2){
        return (l1.a == l2.a) && (l1.b == l2.b);
    }

    public static  boolean areSame(Line l1, Line l2){
        return areParallel(l1, l2) && (l1.c == l2.c);
    }

    public static Point areIntersect(Line l1, Line l2){
        double y;
        double x = (l2.b*l1.c - l1.b*l2.c)/(l2.a*l1.b - l1.a*l2.b);
        if(l1.b > 0){
             y = -(l1.a*x + l1.c);
        }else{
            y = -(l2.a*x + l2.c);
        }

        return new Point(x, y);
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        StringTokenizer st;

        System.out.println("INTERSECTING LINES OUTPUT");
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(sc.nextLine());
            Point p1, p2, p3, p4;
            p1 = new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
            p2 = new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
            p3 = new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
            p4 = new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));

            Line l1 = new Line(p1, p2);
            Line l2 = new Line(p3, p4);

            if(areSame(l1, l2)){
                System.out.println("LINE");
            }else{
                if(areParallel(l1, l2)){
                    System.out.println("NONE");
                }else{
                    Point inte = areIntersect(l1, l2);
                    System.out.format("POINT %.2f %.2f\n", inte.x, inte.y);
                }
            }

        }
        System.out.println("END OF OUTPUT");
    }
}