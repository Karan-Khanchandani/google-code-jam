package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_12442{
   
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            int n = Integer.parseInt(sc.nextLine());
            int parent[] = new int[n+1];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                parent[u] = v;
            }
            int gc = -1, ans = 0;
            for(int i = 1; i <= n; i++){
                int num = i, counter = 0;
                 int p = parent[num];
                while(num != p){
                    System.out.println(p + " send to " + parent[p]);
                    p = parent[p];
                    System.out.println("num = " + num + " p = " + p);
                    counter++;
                }
                if(counter > gc){
                    gc = counter;
                    ans = i;
                }
            }
            System.out.println("Case "+tno+": " + ans);
        }
       
    }
}