package uva_solutions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class uva_00493{
    private static Set<Double> nums = new HashSet<>();

    private static boolean isValid(int num, int den){
        if(den == 0){
            return false;
        }

        if(den < 0){
            den *= -1;
            num *= -1;
        }
        double div = (double) num / (double) den;
        if(nums.contains(div)){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        //left den--
        //right den++
        //up num++
        //down num--
        
       
        Scanner sc =  new Scanner(System.in);
        while(sc.hasNextLine()){
            int nume = 0, deno = 0;
            int size = 1, nIdx = -1, dir = 0;
            nums.clear();
            int index = Integer.parseInt(sc.nextLine());
            boolean cont = true;
            while(nIdx < index && cont){
                //go up
                if(dir == 0 && cont){
                    for(int i = 0; i < size; i++){
                        
                        nume++;
                        if(isValid(nume, deno)){
                            nums.add((double) nume / (double)deno);
                            nIdx++;
                        }

                        if(nIdx >= index){
                            cont = false;
                            break;
                        }
                      
                    }
                    dir = 1;
                }
                //right
                if(dir == 1 && cont){
                    for(int i = 0; i < size; i++){
                        
                        deno++;
                        if(isValid(nume, deno)){
                            nums.add((double) nume / (double)deno);
                            nIdx++;
                        }
                        if(nIdx >= index){
                            cont = false;
                            break;
                        }
                       
                    }
                    dir = 2;
                    size++;
                }
                //down
                if(dir == 2 && cont){
                    for(int i = 0; i < size; i++){
                        
                        nume--;
                        if(isValid(nume, deno)){
                            nums.add((double) nume / (double)deno);
                            nIdx++;
                        }

                        if(nIdx >= index){
                            cont = false;
                            break;
                        }
                    }
                    dir = 3;
                }
                //left
                if(dir == 3 && cont){
                    for(int i = 0; i < size; i++){
                       
                        deno--;
                        if(isValid(nume, deno)){
                            nums.add((double) nume / (double)deno);
                            nIdx++;
                        }

                        if(nIdx >= index){
                            cont = false;
                            break;
                        }
                      
                    }
                    size++;
                    dir = 0;
                }
            }

            if(deno < 0){
                deno *= -1;
                nume *= -1;
            }
            
            System.out.println(nume + " / " + deno);
        }
    }
}