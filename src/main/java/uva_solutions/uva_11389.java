package uva_solutions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11389{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int num, overtime, rate;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            num = Integer.parseInt(st.nextToken());
            overtime = Integer.parseInt(st.nextToken());
            rate = Integer.parseInt(st.nextToken());

            if(num == 0 && overtime == 0 && rate == 0){
                break;
            }

            int morn[] = new int[num];
            int even[] = new int[num];

            st = new StringTokenizer(sc.nextLine());
            for(int i = 0; i < num; i++){
                morn[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(sc.nextLine());
            for(int i = 0; i < num; i++){
                even[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(morn);
            Arrays.sort(even);
            

            int sum = 0;
            for(int i =0; i < num; i++){
                if(morn[i] + even[num - i - 1] > overtime){
                 
                    sum += (morn[i] + even[num - i - 1]) - overtime;
                   
                }
            }

            System.out.println(sum*rate);
        }
    }
}