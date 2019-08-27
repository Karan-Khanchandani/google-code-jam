package uva_solutions;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_10523{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            BigInteger A = new BigInteger(String.valueOf(a));
            BigInteger sum = BigInteger.ZERO;
            for(int i = 1; i<=n;i++){
                BigInteger temp = A.pow(i);
                sum = sum.add(temp.multiply(new BigInteger(String.valueOf(i))));
            
            }
            System.out.println(sum);
        }
    }
}