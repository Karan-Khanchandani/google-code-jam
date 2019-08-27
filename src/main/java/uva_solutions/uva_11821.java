package uva_solutions;

import java.math.BigDecimal;
import java.util.Scanner;

public class uva_11821{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            BigDecimal sum = BigDecimal.ZERO;
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                if(s.equals("0")){
                    break;
                }
               sum =  sum.add(new BigDecimal(s));
            }
            System.out.println(sum.stripTrailingZeros().toPlainString());
        }
    }
}