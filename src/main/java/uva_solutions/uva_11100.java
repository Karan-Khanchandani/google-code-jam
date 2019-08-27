package uva_solutions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11100{

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        boolean f = true;
        while(sc.hasNextLine()){
            n = Integer.parseInt(sc.nextLine());
            if( n == 0){
                break;
            }
            if(f){
                f = false;
            }else{
                System.out.println();
            }
            int bags[] = new int[n];
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for(int i = 0; i < n; i++){
                bags[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(bags);
            int maxBag = -1, curr = 1;
            for(int i = 0; i < n - 1; i++){
                if(bags[i] == bags[i+1]){
                    curr++;
                    continue;
                }
                maxBag = Math.max(maxBag, curr);
                curr = 1;
            }
            maxBag = Math.max(maxBag, curr);

            System.out.println(maxBag);
            for(int i = 0; i < maxBag; i++){
                boolean first = true;
                for(int j = i; j < n; j+=maxBag){
                    if(first){
                        first = false;
                    }else{
                        System.out.print(" ");
                    }
                    System.out.print(bags[j]);
                }
                System.out.println();
            }
           
        }
    }
}