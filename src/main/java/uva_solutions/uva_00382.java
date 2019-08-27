package uva_solutions;

import java.util.Scanner;

public class uva_00382{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n;
        System.out.println("PERFECTION OUTPUT");
        do{
            n = sc.nextInt();
            if(n == 0){
                break;
            }
            int sum = 0;
            String ans = "";
            for(int i = 1; i < n; i++){
                if(n%i == 0){
                    sum += i;
                }
            }

            if(sum == n){
                ans = "PERFECT";
            }else if(sum < n){
                ans = "DEFICIENT";
            }else{
                ans = "ABUNDANT";
            }

            System.out.format("%5s  %s%n", n, ans);
        }while(true);
        System.out.println("END OF OUTPUT");
    }
}