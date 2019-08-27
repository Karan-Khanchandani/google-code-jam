package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_00191{

    private static double EPS = 1e-9;
    private static class Point{
        private double x, y;
        public Point(double x,double  y){
            this.x = x;
            this.y = y; 
        }
    }

    private static class Line{
        private double a,b,c;
        public Line(Point p1, Point p2){
            if(Math.abs(p1.x - p2.x) < EPS){
                b = 0.0;
                a = 1.0;
                c = -(p1.x);
            }else{
                b = 1.0;
                a = -(p1.y - p2.y)/(p1.x - p2.x);
                c = -(a*p1.x) - p1.y; 
            }
        }
    }

    private static boolean areParallel(Line l1, Line l2){
        return Math.abs(l1.a - l2.a) < EPS && Math.abs(l1.b - l2.b) < EPS;
    }

    private static boolean areIntersect(Line l1, Line l2, Point p){
        if(areParallel(l1, l2)){
            return false;
        }

         p.x = (l1.b*l2.c - l2.b*l1.c)/(l1.a*l2.b - l2.a*l1.b);
        if(Math.abs(l1.b) > EPS){
            p.y = -(l1.a*p.x + l1.c);
        }else{
            p.y = -(l2.a*p.x + l2.c);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            Line line = new Line(new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())),new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())));
            double xleft, ytop, xright, ybottom;
            xleft = Double.parseDouble(st.nextToken());
            ytop = Double.parseDouble(st.nextToken());
            xright = Double.parseDouble(st.nextToken());
            ybottom = Double.parseDouble(st.nextToken());

            Line left = new Line(new Point(xleft, ybottom), new Point(xleft, ytop));
            Line right = new Line(new Point(xright, ybottom), new Point(xright, ytop));
            Line top = new Line(new Point(xleft, ytop), new Point(xright, ytop));
            Line bottom = new Line(new Point(xleft, ybottom), new Point(xright, ybottom));

            Point pleft, pright, ptop, pbottom;
            pleft = new Point(-1, -1);
            pright = new Point(-1, -1);
            ptop = new Point(-1, -1);
            pbottom = new Point(-1, -1);

            boolean flag = true;
            if(areIntersect(line, left, pleft) && flag){
                if(pleft.y >= ybottom && pleft.y <= ytop && pleft.x == xleft){
                    flag = false;
                    System.out.println("T");
                }
            }

            if(areIntersect(line, right, pright) && flag){
                if(pright.y >= ybottom && pright.y <= ytop && pright.x == xright){
                    flag = false;
                    System.out.println("T");
                }
            }

            if(areIntersect(line, top, ptop) && flag){
                if(ptop.x >= xleft && ptop.x <= xright && ptop.y == ytop){
                    flag = false;
                    System.out.println("T");
                }
            }

            if(areIntersect(line, bottom, pbottom) && flag){
                if(pbottom.x >= xleft && pbottom.x <= xright && pbottom.y == ybottom){
                    flag = false;
                    System.out.println("T");
                }
            }

            if(flag){
                System.out.println("F");
            }


        }
    }
}