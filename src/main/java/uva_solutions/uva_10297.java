package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10297{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("0 0")){
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            double volumeChopped, outerDia;
            outerDia = Double.parseDouble(st.nextToken());
            volumeChopped = Double.parseDouble(st.nextToken());
            double remainVol = Math.PI*Math.pow(outerDia, 3)*0.25 - volumeChopped;
            double d_cube = 6*remainVol - Math.PI*Math.pow(outerDia, 3)*0.5;
            d_cube = d_cube/Math.PI;
            double ans = Math.pow(d_cube, 0.3333333333);

            System.out.format("%.3f\n", ans);
            
        }
    }
}