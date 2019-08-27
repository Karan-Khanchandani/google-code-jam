package uva_solutions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class uva_00599{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int tno = 1; tno <= t; tno++){
            String line;
            boolean map[][] = new boolean[26][26];
           while(sc.hasNextLine()){
               line = sc.nextLine();
               if(line.charAt(0) == '*'){
                   break;
               }

               int a = line.charAt(1) - 'A';
               int b = line.charAt(3) - 'A';
               map[a][b] = true;
               map[b][a] = true;
           }

           int vertices[] = new int[26];
           line = sc.nextLine();
           for(int i = 0, j = 1; i < line.length();i++){
               Character c = line.charAt(i);
               if(c >= 'A' && c <= 'Z'){
                   vertices[c - 'A'] = j++;
               }
           }

           //first bfs and assign same value to all nodes
           boolean visited[] = new boolean[26];
           for(int i = 0; i < 26; i++){
               if(vertices[i] != 0 && !visited[i]){
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                visited[i] = true;
                int g = vertices[i];
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int j = 0; j < 26; j++){
                        if(vertices[j] != 0 && map[curr][j] && !visited[j]){
                            q.add(j);
                            vertices[j] = g;
                            visited[j] = true;
                        }
                    }
                }
               }
              
           }

           //group all the trees
           int group[] = new int[27];
           for(int i = 0; i < 26; i++){
               if(vertices[i] == 0){
                   continue;
               }
               group[vertices[i]]++;
           }

           int tree = 0, acorn = 0;
           for(int i = 0; i < 27; i++){
               if(group[i] > 1){
                   tree++;
               }else if(group[i] == 1){
                   acorn++;
               }
           }

           System.out.println("There are " + tree + " tree(s) and " + acorn + " acorn(s).");
           
        }
    }
}