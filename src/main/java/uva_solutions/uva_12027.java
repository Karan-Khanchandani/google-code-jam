package uva_solutions;

import java.util.Scanner;

public class uva_12027{
    public static void main(String[] args) {
        //ans  = Math.floor(sqrt(n))
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){

            String line = sc.nextLine();

            if(line.equals("0")){
                break;
            }

            int length = line.length();

            int num = line.charAt(0) - '0';
            if(length > 1 && length%2 == 0){
                num = num*10 + (line.charAt(1) - '0');
            }
            System.out.print((int)Math.sqrt(num));
            length = (length - 1)/2;
            for(int i = 0; i < length; i++){
                System.out.print("0");
            }
            System.out.println();
           
        }
    }
}