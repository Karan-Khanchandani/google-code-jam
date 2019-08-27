package uva_solutions;

import java.util.Scanner;

public class uva_10851{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());

            for(int tno = 1; tno <= n; tno++){
                
                char str[][] = new char[10][100];
               // str[0] = s.toCharArray();
               int len = 0;
                for(int i = 0; i < 10; i++){
                    String s = sc.nextLine();
                    len = s.length();
                    str[i] = s.toCharArray();
                    //System.out.println(str[i]);
                }
                
                for(int i = 1; i < len -1; i++){
                    int sum = 0, power = 0;
                    for(int j = 0; j< 9; j++){
                        if(str[j][i] == '\\'){
                            sum += (int)Math.pow(2, power - 1);
                            
                        }
                        power++;
                    }
                    char b = (char)(sum);
                   // System.out.print(sum + " ");
                    System.out.print(b);
                }
                
                if(tno != n){
                    sc.nextLine();
                    System.out.println();
                }
               
            }
        }
    }
}