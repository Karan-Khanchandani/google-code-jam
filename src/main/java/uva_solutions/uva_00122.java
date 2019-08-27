package uva_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class uva_00122{
    static class Node{
        int val;
        Node left, right;
        public Node(){
            val = -1;
            left = right = null;
        }

        void setKey(int k){
            val = k;
        }
    }
    static Node root;

    static boolean insert(int k, String path){
        if(path.isEmpty()){
            if(root.val != -1 && root.val != k){
                return false;
            }
            root.setKey(k);
            return true;
        }
        Node node = root;
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == 'L'){
                if(node.left == null)
                    node.left = new Node();
                node = node.left;
            }else{
                if(node.right == null)
                    node.right = new Node();
                node = node.right;
            }
        }
        if(node.val != -1 && node.val != k)
            return false;
        node.setKey(k);
        return true;
    }

    static boolean valid(Node node){
        if(node == null) return true;
        if(node.val == -1) return false;
        
        if(!valid(node.left) || !valid(node.right)) return false;
        return true;
    }

    static void bfs(){
        Queue<Node> Q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
		
		Node node = root;
		Q.offer(node);
		while (!Q.isEmpty()) {
			Node x = Q.poll();
			list.add(x.val);
			
			if (x.left != null)
				Q.offer(x.left);
			if (x.right != null)
				Q.offer(x.right);
		}
		for (int i = 0; i < list.size(); ++i) {
			if (i > 0) System.out.print(" ");
			System.out.print(list.get(i));
		}
		System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String token;
            ArrayList<String> tokens = new ArrayList<String>();
            while(sc.hasNext() && !(token = sc.next()).equals("()"))
                tokens.add(token);
            root = new Node();
            boolean ok = true;
            for(String s: tokens){
                String[] parts = s.split(",");
				int k = Integer.parseInt(parts[0].substring(1));
				String path = parts[1].substring(0, parts[1].length() - 1);
				
				ok &= insert(k, path);
            }

            if (ok && !valid(root))
					ok = false;
			if (!ok)
				System.out.println("not complete");
			else
				bfs();
        }

        sc.close();
        System.exit(0);
    }
}