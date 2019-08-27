package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11723{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 0;
        while(true){
            String line = sc.nextLine();
            if(line.equals("0 0")){
                break;
            }
            t++;
            int roads, n;
            StringTokenizer st = new StringTokenizer(line);
            roads = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int ans = (int) Math.ceil((double) (roads - n)/(double)n);

            if(ans > 26){
                System.out.println("Case " + t + ": "+"impossible");
            }else{
                System.out.println("Case " + t + ": "+ans);
            }
        }
    }
}