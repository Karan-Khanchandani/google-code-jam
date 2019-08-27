package uva_solutions;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_00713{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for(int tno = 1; tno <= t; tno++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());

            String a_rev = new StringBuffer(a.toString()).reverse().toString();
            String b_rev = new StringBuffer(b.toString()).reverse().toString();

            BigInteger a_r = new BigInteger(a_rev);
            BigInteger b_r = new BigInteger(b_rev);

            a_r = a_r.add(b_r);

            String ans = new StringBuffer(a_r.toString()).reverse().toString();
            BigInteger as = new BigInteger(ans);
            System.out.println(as.toString());

        }
    }
}