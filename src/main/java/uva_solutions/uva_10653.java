package uva_solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class uva_10653{
    private static int r,c;
    private static int[][] adj;
    
    private static class Pair{
        int x,y, depth;
        public Pair(int x,int y, int d){
            this.x = x;
            this.y = y;
            this.depth = d;
        }
    }

    private static boolean isValid(int x, int y){
        if(x >= 0 && x < r  && y >= 0 && y < c && adj[x][y] != -1){
            return true;
        }
        return false;
    }

    private static int findMin(int startRow, int startCol, int endRow, int endCol){
        Queue<Pair> q = new LinkedList<>();
        if(adj[startRow][startCol] != -1){
            q.add(new Pair(startRow, startCol, 0));
        }
        int ans = 0;
        adj[startRow][startCol] = -1;
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();
            if(p.x == endRow && p.y == endCol){
                ans = p.depth;
                break;
            }
            if(isValid(p.x + 1, p.y)){
                q.add(new Pair(p.x + 1, p.y, p.depth +1));
                adj[p.x + 1][p.y] = -1;
            }
            if(isValid(p.x -1, p.y)){
                q.add(new Pair(p.x - 1, p.y, p.depth +1));
                adj[p.x - 1][p.y] = -1;
            }
            if(isValid(p.x, p.y+1)){
                q.add(new Pair(p.x, p.y + 1, p.depth +1));
                adj[p.x][p.y + 1] = -1;
            }
            if(isValid(p.x, p.y -1)){
                q.add(new Pair(p.x, p.y - 1, p.depth +1));
                adj[p.x][p.y - 1] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line;
            line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(r == 0 && c == 0){
                break;
            }
            adj = new int[r][c];
            for(int i = 0; i < r; i++){
                adj[i] = new int[c];
            }

            int rows = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < rows; i++){
                line = sc.nextLine();
                st = new StringTokenizer(line);
                int rowIdx = Integer.parseInt(st.nextToken());
                int numB = Integer.parseInt(st.nextToken());
                for(int j = 0; j < numB; j++){
                    int des = Integer.parseInt(st.nextToken());
                    adj[rowIdx][des] = -1;
                }
            }
            line = sc.nextLine();
            int startRow, startCol, endRow, endCol;
            st = new StringTokenizer(line);
            startRow = Integer.parseInt(st.nextToken());
            startCol = Integer.parseInt(st.nextToken());

            line = sc.nextLine();  
            st = new StringTokenizer(line);
            endRow = Integer.parseInt(st.nextToken());
            endCol = Integer.parseInt(st.nextToken());

            System.out.println(findMin(startRow, startCol, endRow, endCol));
        } 
    }
}