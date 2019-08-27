package uva_solutions;

import java.util.Scanner;

public class uva_00264{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int t = Integer.parseInt(sc.nextLine());
            int sum = 0, line = 1;
           for(int i = 1; ; i++){
            sum += i;
            if(sum >= t){
                line = i;
                break;
            }
           }
           int nume = -1 ,den = -1;
           if(line%2 == 1){
               nume = 1 + sum - t;
               den = line - (sum - t);
           }else{
            den = 1 + sum - t;
            nume = line - (sum - t);
           }
           
            
            System.out.format("TERM %d IS %d/%d\n", t, nume, den);
        }
    }
}