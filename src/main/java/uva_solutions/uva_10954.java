package uva_solutions;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10954{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            if(n == 0){
                break;
            }

            PriorityQueue<Long> pq = new PriorityQueue<>();
            
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for(int i = 0; i < n; i++){
                pq.add(Long.parseLong(st.nextToken()));
            }

            long  cost = 0;
            while(!pq.isEmpty() && n > 1){
                long x = pq.poll() + pq.poll();
                cost += x;
                pq.offer(x);
                n--;
            }

            System.out.println(cost);
        }
    }
}