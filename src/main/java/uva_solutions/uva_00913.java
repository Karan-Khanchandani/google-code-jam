package uva_solutions;

import java.util.Scanner;

public class uva_00913{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            long num = Long.parseLong(sc.nextLine());
            long line = (num + 1)/2;
            long last_num = (line)*(line);
            long last_num_odd = 2*last_num - 1;
            System.out.println(last_num_odd + last_num_odd -2 + last_num_odd - 4);
        }

    }
}