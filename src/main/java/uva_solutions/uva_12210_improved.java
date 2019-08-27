package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_12210_improved{
    public static void main(String[] args) {
        int b, s;
        Scanner sc = new Scanner(System.in);
        int tno = 0;
        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            b = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            if(b == 0 && s == 0){
                break;
            }
            tno++;
            int bachelors[] = new int[b];
            int spinster[] = new int[s];
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < b; i++){
                bachelors[i] = Integer.parseInt(sc.nextLine());
                min = Math.min(min, bachelors[i]);
            }

            for(int i = 0; i < s; i++){
                spinster[i] = Integer.parseInt(sc.nextLine());
            }

           
           if(b <= s){
               System.out.println("Case "+ tno + ": " + "0");
           }else{
               System.out.println("Case "+ tno + ": " + (b - s) + " " + min);
           }
        }
    }
}