package uva_solutions;

import java.util.HashMap;
import java.util.Scanner;

public class uva_11572{
    //We need to find longest duplicate free subarray
    public static void main(String[] args){
        int t;
        Scanner sc = new Scanner(System.in);
        t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            int n_snow = Integer.parseInt(sc.nextLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            int start = 0, res = 0;
            for(int i = 0; i < n_snow; i++){
                Integer sf = Integer.parseInt(sc.nextLine());
                if(map.containsKey(sf)){
                    Integer idx = map.get(sf);
                    if(idx >= start){
                        start = idx + 1;
                    }
                    res = Math.max(res, i - start + 1);
                    map.put(sf, i);
                }else{
                    res = Math.max(res , i + 1 - start);
                    map.put(sf, i);
                }
            }

            System.out.println(res);
        }
    }
}