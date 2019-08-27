package uva_solutions;

import java.util.Arrays;
import java.util.Scanner;

public class uva_00543{
    private static boolean[] bs;
    
    private static void sieve(int upperbound){
        bs = new boolean[upperbound];
        Arrays.fill(bs, true);
        bs[0] = bs[1] = false;
        for(int i = 2; i < upperbound; i++){
            if(bs[i]){
                int mul=2;
				while(mul*i<1000001)
					bs[mul++*i]=false;
            }
            }
            
    }
    public static void main(String[] args) {
        sieve(1000001);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int num = Integer.parseInt(sc.nextLine());
            if(num == 0){
                break;
            }
            int ans1 = 0, ans2  =0;
            for(int i = 3; i <= num/2; i++){
                if(bs[i] && bs[num - i]){
                    ans1 = i;
                    ans2 = num - i;
                    break;
                } 
            }
            System.out.format("%d = %d + %d\n", num, ans1, ans2);
        }
        
    }
}