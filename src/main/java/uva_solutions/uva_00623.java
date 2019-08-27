package uva_solutions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class uva_00623{
    private static BigInteger[] fact;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        List<Integer> ip = new ArrayList<>();
        int max = -1;
        while(sc.hasNextLine()){
            int num = Integer.parseInt(sc.nextLine());
            max = Math.max(max, num);
            ip.add(num);
        }
        fact = new BigInteger[max+1];
        fact[0] = BigInteger.ONE;
        fact[1] = BigInteger.ONE;
        for(int i = 2; i <= max; i++){
            fact[i] = fact[i-1].multiply(new BigInteger(String.valueOf(i)));
        }

        for(int i = 0; i < ip.size(); i++){
            System.out.println(ip.get(i) + "!");
            System.out.println(fact[ip.get(i)].toString());
        }
    }
}