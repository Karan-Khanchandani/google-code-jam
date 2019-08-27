package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_01237{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for(int tno =  1; tno <= t; tno++){

            if(tno != 1){
                System.out.println();
            }
            
            int entries = Integer.parseInt(sc.nextLine());
            String[] makers = new String[entries];
            int[] low = new int[entries];
            int[] high = new int[entries];
            StringTokenizer st;

            for(int i = 0; i < entries; i++){
                st = new StringTokenizer(sc.nextLine());
                makers[i] = st.nextToken();
                low[i] = Integer.parseInt(st.nextToken());
                high[i] = Integer.parseInt(st.nextToken());
            }

            int n_queries = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < n_queries; i++){
                int count = 0, ansIndex = -1;
                int price = Integer.parseInt(sc.nextLine());
                for(int j = 0; j < entries; j++){
                    if(price < low[j] || price > high[j]){
                        continue;
                    }
                    count++;
                    ansIndex = j;
                    if(count > 1){
                        ansIndex = -1;
                        break;
                    }
                }

                if(ansIndex == -1){
                    System.out.println("UNDETERMINED");
                }else{
                    System.out.println(makers[ansIndex]);
                }

            }

        }
    }
}