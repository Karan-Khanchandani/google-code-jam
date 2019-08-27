package uva_solutions;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_01230{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t ; tno++){
            BigInteger x, y ,n;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            x = new BigInteger(st.nextToken());
            y = new BigInteger(st.nextToken());
            n = new BigInteger(st.nextToken());
            x = x.modPow(y, n);
            System.out.println(x);
        }
        sc.nextLine();
        sc.close();
    }
}