package uva_solutions;

import java.util.*;

public class uva_00152{
    private static double eps = 1e-9;
    private static class Point{
        private double x,y,z;
        public Point(double x, double y, double z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static double dist(Point a, Point b){
        return Math.sqrt((b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y) + (b.z - a.z)*(b.z - a.z));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x, y, z;
        List<Point> points = new ArrayList<>();
        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            z = Double.parseDouble(st.nextToken());

            if(Math.abs(x) < eps && Math.abs(y) < eps && Math.abs(z) < eps){
                break;
            }

            points.add(new Point(x, y, z));
        }

        Collections.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point a, Point b){
               return (int)((a.x != b.x) ? (a.x - b.x) : (a.y != b.y) ? (a.y - b.y) : (a.z - b.z));
            }
        });

        int count[] = new int[10];
        
        for(int i = 0; i < points.size(); i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < points.size(); j++){
                if(j == i){
                    continue;
                }
                int distan = (int) dist(points.get(i), points.get(j));
                min = Math.min(min, distan);
            }
            if(min < 10)
            count[min]++;
        }
        

        for(int k = 0; k < 10; k++){
            
                System.out.format("%4s", count[k]);
            }
            System.out.println();
        
    }
}