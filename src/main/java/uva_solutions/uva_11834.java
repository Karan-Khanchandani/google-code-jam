package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11834{

    private static boolean isPossible(double l, double w, double r1, double r2){
        //assumes r1 > r2 && l > w
        if(2*r1 > w || 2*r2 > w){
            return false;
        }

        double dx = w - r1 - r2, dy = l - r1 - r2, d = r1+r2;
        if(dx*dx + dy*dy >= d*d){
            return true;
        }

        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            double l, w, r1, r2;
            String line = sc.nextLine();

            if(line.equals("0 0 0 0")){
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            l = Double.parseDouble(st.nextToken());
            w = Double.parseDouble(st.nextToken());
            r1 = Double.parseDouble(st.nextToken());
            r2 = Double.parseDouble(st.nextToken());

            if(l < w){
                double temp = w;
                w = l;
                l = temp;
            }

            if(r1 < r2){
                double temp = r1;
                r1 = r2;
                r2 = temp;
            }

            if(isPossible(l, w, r1, r2)){
                System.out.println("S");
            }else{
                System.out.println("N");
            }
        }
    }
}