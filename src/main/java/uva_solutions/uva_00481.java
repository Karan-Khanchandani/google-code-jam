package uva_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class uva_00481{
    static int[] L_id, P;

    static void printLis(ArrayList<Integer> nums,int end){
        int x = end;
        Stack<Integer> s = new Stack();
        for (; P[x] >= 0; x = P[x]) s.push(nums.get(x));
        System.out.println(nums.get(x));
        for (; !s.isEmpty(); s.pop()) System.out.println(s.peek());
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            nums.add(Integer.parseInt(sc.nextLine()));
        }
        ArrayList<Integer> lis = new ArrayList<>();
        L_id = new int[nums.size()];
        P = new int[nums.size()];
        int lis_s = 0, lis_end = 0;
        for(int i = nums.size() - 1; i >= 0; i--){
            int pos = Collections.binarySearch(lis, nums.get(i));
            if(pos < 0) pos = -(pos + 1);
            if(pos >= lis.size()) lis.add(nums.get(i));
            else lis.set(pos, nums.get(i));
            L_id[pos] = i;
            P[i] = (pos > 0) ?  L_id[pos - 1]: -1;
            if(pos + 1 > lis_s){
                lis_s = pos + 1;
                lis_end = i;
            }
        }

        System.out.println(lis.size());
        System.out.println("-");
        printLis(nums ,lis_end);
       
    }
}