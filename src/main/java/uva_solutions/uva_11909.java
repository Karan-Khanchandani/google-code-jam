package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11909{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            double l,w,h, angle;
            l = Double.parseDouble(st.nextToken());
            w = Double.parseDouble(st.nextToken());
            h = Double.parseDouble(st.nextToken());
            angle = Double.parseDouble(st.nextToken());

            angle = angle*Math.PI/180;
            double c = Math.atan(h / l);
			if(angle <= c)
				System.out.printf("%.3f mL\n", (l * h - 0.5 * l * l * Math.tan(angle)) * w);
			else
			{
				angle = Math.PI / 2 - angle;
				System.out.printf("%.3f mL\n", 0.5 * h * h * Math.tan(angle) * w);
			}
        }
    }
}