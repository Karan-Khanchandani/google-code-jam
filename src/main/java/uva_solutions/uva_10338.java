package uva_solutions;

import java.math.BigInteger;
import java.util.Scanner;

public class uva_10338{
    private static BigInteger fact[];
    public static void main(String[] args) {
        fact = new BigInteger[21];
        fact[0] = fact[1] = BigInteger.ONE;
        for(int i = 2; i < 21; i++){
            fact[i] = fact[i-1].multiply(new BigInteger (String.valueOf(i)));
        }
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            String str = sc.nextLine();
            int count[] = new int[256];
            for(int i = 0; i < str.length(); i++){
                count[(int) str.charAt(i)]++;
            }
            BigInteger nume = fact[str.length()];
            BigInteger deno = BigInteger.ONE;
            for(int i = 0; i < 256; i++){
                if(count[i] > 0){
                    deno = deno.multiply(fact[count[i]]);
                }
            }

            BigInteger ans = nume.divide(deno);

            System.out.println("Data set "+tno+": " + ans.toString());

        }
    }
}