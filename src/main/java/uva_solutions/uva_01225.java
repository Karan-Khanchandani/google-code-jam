package uva_solutions;

import java.util.Scanner;

public class uva_01225{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            int n = Integer.parseInt(sc.nextLine());
            StringBuffer sb = new StringBuffer();
            for(int i = 1; i <= n; i++){
                sb.append(Integer.toString(i));
            }

            int count[] = new int[10];
            for(int i = 0; i < sb.length(); i++){
                count[(int)(sb.charAt(i) - '0')]++;
            }

            for(int i = 0; i < 10; i++){
                System.out.print(count[i]);
                if(i != 9){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}