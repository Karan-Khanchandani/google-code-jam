package uva_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class uva_11286{

    private static class Courses{
        int id = 0;
        int[] arr;

        public Courses(int arr[]){
            this.arr = arr;
            Arrays.sort(arr);
            for(int i = 0; i < 5; i++){
                id += (arr[i] << 1);
            }
        }

        @Override
        public boolean equals(Object o){
            Courses c = (Courses) o;
            for(int i = 0; i < 5 ;i++){
                if(arr[i] != c.arr[i]){
                    return false;
                }
            }
            return true;    
        }

        @Override
        public int hashCode(){
            return id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("0")){
                break;
            }

            int students = Integer.parseInt(line);
            Map<Courses, Integer> map = new HashMap<>();
            int max = 1;
            for(int i = 0; i < students; i++){
                int[] arr = new int[5];
                String input = sc.nextLine();
                String[] ip = input.split(" ");
                for(int j = 0; j <5; j++){
                     arr[j] = Integer.parseInt(ip[j]);  
                }

                Courses c = new Courses(arr);
                if(!map.containsKey(c)){
                    map.put(c, 1);
                }else{
                    map.put(c, map.get(c) + 1);
                    max = Math.max(max, map.get(c));
                }   
            }

            int res = 0;
            for (Map.Entry<Courses, Integer> i : map.entrySet()) {
                int x = i.getValue();
                if (x == max) {
                    res += x;
                }
            }
            System.out.println(res);
            
        }
    }
}