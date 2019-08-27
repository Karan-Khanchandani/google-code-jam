package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10718{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            long n, l, u;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            n = Long.parseLong(st.nextToken());
            l = Long.parseLong(st.nextToken());
            u = Long.parseLong(st.nextToken());

            long ans = 0, left, right;
            for(int i = 31; i>=0; i--){
                if((n &(1L << i)) > 0){
                    left = ans + (1L << i);
                    if(left <= l){
                        ans += (1L << i);
                    }
                }else{
                    right = ans + (1L << i);
                    if(right <= u){
                        ans += (1L << i);
                    }
                }
            }

            System.out.println(ans);
        }
    }
}