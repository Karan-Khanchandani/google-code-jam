package uva_solutions;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class uva_10226{
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        sc.nextLine();
        for(int tno = 1; tno <=t; tno++){
            Map<String, Integer> map = new TreeMap<>();
            int count = 0;
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.equals("")){
                    break;
                }

                if(!map.containsKey(line)){
                    map.put(line, 1);
                }else{
                    map.put(line, map.get(line) + 1);
                }

                count++;
            }
            if(tno != 1){
                System.out.println();
            }
            for(Map.Entry<String, Integer> entry: map.entrySet()){
                double ans = (double)(entry.getValue()*1.0)/(count*1.0);
                System.out.format("%s %.4f\n",entry.getKey(), ans*100);
            }
            
        }
    }
}