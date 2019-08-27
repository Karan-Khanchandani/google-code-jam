package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11130{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            double a, b, v, A ,s;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            a = Double.parseDouble(st.nextToken());
            b = Double.parseDouble(st.nextToken());
            v = Double.parseDouble(st.nextToken());
            A = Double.parseDouble(st.nextToken());
            s = Double.parseDouble(st.nextToken());
            
            if(a == 0.0 && b == 0.0 && v == 0.0 && A == 0.0 && s == 0.0){
                break;
            }

            double dist = v*s/2;
            double hdist = dist*Math.cos((A*Math.PI)/180);
            double vdist = dist*Math.sin((A*Math.PI)/180);
            
            int hans = (int) ((hdist + a/2)/a);
            int vans = (int) ((vdist + b/2)/b);

            System.out.println(hans + " " + vans);
            
        }
    }
}