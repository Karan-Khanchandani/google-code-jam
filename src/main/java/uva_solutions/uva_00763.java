package uva_solutions;

import java.math.BigInteger;
import java.util.Scanner;

public class uva_00763{
    private static BigInteger[] fib = new BigInteger[105];

    private static String convertBigToFib(BigInteger num){
        if(num.equals(BigInteger.ZERO)){
            return "0";
        }
        int idx = -1;
        for(int i = 104; i >= 0; i--){
            if(num.compareTo(fib[i]) < 0){
                continue;
            }
            idx = i;
            break;
        }

        StringBuffer sb = new StringBuffer();
        while(idx >= 0){
            if(num.compareTo(fib[idx]) < 0){
                sb.append("0");
            }else{
                num = num.subtract(fib[idx]);
                sb.append("1");
            }
            idx--;
        }

        return sb.toString();

    }

    private static String findFibSum(String num1, String num2){
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ZERO;
        for(int i = num1.length() - 1; i >= 0; i--){
            if(num1.charAt(i) == '1'){
                first = first.add(fib[num1.length() - 1 - i]);
            }
        }

        for(int i = num2.length() - 1; i >= 0; i--){
            if(num2.charAt(i) == '1'){
                second = second.add(fib[num2.length() - 1 - i]);
            }
        }
       
        BigInteger sum = first.add(second);
        
        String ans = convertBigToFib(sum);
        return ans;
    }

    public static void main(String[] args) {

        fib[0] = BigInteger.ONE;
        fib[1] = BigInteger.ONE.add(BigInteger.ONE);
        for(int i = 2; i < 105; i++) {
            fib[i] = fib[i-1].add(fib[i-2]);
        }  
        
        
        Scanner sc = new Scanner(System.in);
        boolean first = true;
        while(sc.hasNextLine()){
            if(first){
                first = false;
            }else{
                System.out.println();
                sc.nextLine();
            }
            String num1 = sc.nextLine();
            String num2 = sc.nextLine();
            
            String res = findFibSum(num1, num2);
            System.out.println(res);
        }
    }
}