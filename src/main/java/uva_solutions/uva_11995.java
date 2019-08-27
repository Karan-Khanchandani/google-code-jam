package uva_solutions;

import java.util.*;

public class uva_11995{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){

            int n = Integer.parseInt(sc.nextLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            boolean isS = true, isQ = true, isPQ = true;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                if(!isPQ && !isQ && !isS){
                    continue;
                }    
                int opt_one = Integer.parseInt(st.nextToken());
                
                if(opt_one == 1){
                    int numberToBeInserted = Integer.parseInt(st.nextToken());
                    if(isPQ){
                        pq.add(numberToBeInserted);
                    }
                    if(isQ){
                        queue.add(numberToBeInserted);
                    }

                    if(isS){
                        stack.push(numberToBeInserted);
                    }

                }else{
                    int numToBeChecked = Integer.parseInt(st.nextToken());

                    if(isPQ && !pq.isEmpty()){
                       if(pq.poll() != numToBeChecked){
                           isPQ = false;
                       }
                    }else{
                        isPQ = false;
                    }

                    if(isQ && !queue.isEmpty()){
                        if(queue.remove() != numToBeChecked){
                            isQ = false;
                        }
                     }else{
                         isQ = false;
                     }

                     if(isS && !stack.isEmpty()){
                        if(stack.pop() != numToBeChecked){
                            isS = false;
                        }
                     }else{
                         isS = false;
                     }
                }
            }

            //check conditions
            //if all are not empty
            if(!isPQ && !isQ && !isS){
                System.out.println("impossible");
            }else if(!isPQ && !isQ && isS){
                System.out.println("stack");
            }else if(!isPQ && isQ && !isS){
                System.out.println("queue");
            }else if(isPQ && !isQ && !isS){
                System.out.println("priority queue");
            }else{
                System.out.println("not sure");
            }
            
        }
    }
}