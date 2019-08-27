package uva_solutions;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class uva_00978{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            String line = sc.nextLine();
            String ip[] = line.split(" ");
            int n_batt = Integer.parseInt(ip[0]);
            int n_green = Integer.parseInt(ip[1]);
            int n_blue = Integer.parseInt(ip[2]);

            PriorityQueue<Integer> greens=new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> blues=new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0; i < n_green; i++){
                greens.add(Integer.parseInt(sc.nextLine()));
            }

            for(int i = 0; i < n_blue; i++){
                blues.add(Integer.parseInt(sc.nextLine()));
            }

            while(!blues.isEmpty() && !greens.isEmpty()){
                int[] greenRem = new int[n_batt];
                int[] blueRem = new int[n_batt];
                int n_blueRem = 0, n_greenRem = 0;
                int round = Math.min(n_batt, Math.min(greens.size(), blues.size()));
                for(int i = 0; i < round; i++){
                    Integer f_blue = blues.poll();
                    Integer f_green = greens.poll();

                    if(f_blue < f_green){
                        greenRem[n_greenRem++] = f_green - f_blue;
                    }
    
                    if(f_blue > f_green){
                        blueRem[n_blueRem++] = f_blue - f_green;
                    }
                }

                for(int i = 0; i < n_greenRem; i++){
                    greens.add(greenRem[i]);
                }

                for(int i = 0; i < n_blueRem; i++){
                    blues.add(blueRem[i]);
                }
            }

            if(tno != 1){
                System.out.println();
            }
            if(blues.isEmpty() && greens.isEmpty()){
                System.out.println("green and blue died");
            }else if(blues.isEmpty()){
                System.out.println("green wins");
                while(!greens.isEmpty()){
                    System.out.println(greens.poll());
                }
            }else{
                System.out.println("blue wins");
                while(!blues.isEmpty()){
                    System.out.println(blues.poll());
                }
            }
        }
    }
}