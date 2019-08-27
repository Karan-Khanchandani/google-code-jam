package uva_solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11157{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <=t ;tno++){
            int n,d;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            n  = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            List<Integer> stones =  new ArrayList<>();
            stones.add(0);
            stones.add(0);
            st = new StringTokenizer(sc.nextLine());
            for(int i =0 ; i < n; i++){
                String[] ip = st.nextToken().split("-");
                stones.add(Integer.parseInt(ip[1]));
                if(ip[0].equals("B")){
                    stones.add(Integer.parseInt(ip[1]));
                }
            }
            stones.add(d);
            stones.add(d);

            int max = 0;
            for(int i = 2; i < stones.size(); i++){
                max = Math.max(max, stones.get(i) - stones.get(i-2));
            }

            System.out.println("Case "+ tno + ": " + max);
        }
    }
}