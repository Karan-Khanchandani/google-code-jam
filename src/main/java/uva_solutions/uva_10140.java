package uva_solutions;

import java.util.*;

public class uva_10140{
    private static boolean[] bs;

    private static List<Integer> primes;
    private static void sieve(int upperbound){
        bs = new boolean[upperbound+1];
        primes = new ArrayList<>();
        Arrays.fill(bs, true);
        bs[0] = bs[1] = false;
        for(int i = 2; i < upperbound; i++){
            if(bs[i]){
                int mul = 2;
                while(mul*i < upperbound){
                    bs[mul++*i] = false;
                }
                primes.add(i);
            }
           
        }
    }
    private static boolean isprime(long n) {
        if(n < 1000000)
            return bs[(int)n];
         int sq, i;
        sq = (int) Math.sqrt(n);
        for(i = 0; i < primes.size() && primes.get(i) <= sq; i++)
            if(n%primes.get(i) == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sieve(1000001);
        while(sc.hasNextLine()){
            int l, u;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            l = Integer.parseInt(st.nextToken());
            u = Integer.parseInt(st.nextToken());
            long max_d = -1, min_d = Long.MAX_VALUE;
            long last = -1, minx = -1, miny = -1, max= -1, maxy = -1;
            boolean found = false;
            for(long i = l; i <= u ; i++){
                if(isprime(i)){
                    if(last == -1){
                        last = i;
                    }else{
                        if(i - last < min_d){
                            minx = last;
                            miny = i;
                            min_d = i - last;
                        }

                        if(i - last > max_d){
                            max = last;
                            maxy = i;
                            max_d = i - last;
                        }
                        found = true;
                    }
                }
                 
            }

            if(found){
                System.out.format("%d,%d are closest, %d,%d are most distant.\n", minx, miny, max, maxy);
            }else{
                System.out.println("There are no adjacent primes.");
            }
        }
    }
}