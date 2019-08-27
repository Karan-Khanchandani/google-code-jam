package uva_solutions;

import java.util.Scanner;


public class uva_00350{
    static int INF = -1000000;
    public static void main(String[] args) {
        int z, i, m, l;
        Scanner sc = new Scanner(System.in);
        int tno =0;
        while(sc.hasNext()){
            z = sc.nextInt();
            i = sc.nextInt();
            m = sc.nextInt();
            l = sc.nextInt();
            if(z + i + m+ l == 0){
                break;
            }
            tno++;
            int firstNum = (z*l + i)%m;
            l = firstNum;
            int count = 0;
            do{
               l= (z*l + i)%m;
               count++;
            }while(l != firstNum);
            System.out.println("Case " + tno + ": "+ count);
        }
    }
}