package uva_solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_00314{
    private static int[][][] cost;
    private static boolean[][] map;
    private static boolean[][][] visited;
    private static int n,m, dir;

    private static int dr[] = {-1,0,1,0};
    private static int dc[] = {0,1,0,-1};

    private static class Node{
        int r,c,dir;
        public Node(int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    private static boolean isFree(int row, int col){
        if(row <= 0 || row >= n || col <= 0 || col >= m){
            return false;
        }
        if(map[row][col] || map[row-1][col] || map[row][col -1] || map[row -1][col - 1]){
            return false;
        }
        return true;
    }

   
    private static int findMinTime(int startR, int startC, int endR, int endC, int dir){
        int ans = -1;
        Queue<Node> q = new LinkedList<>();
        if(!isFree(startR,startC) || !isFree(endR, endC)){
            return -1;
        }

        cost[startR][startC][dir] = 0;
        visited[startR][startC][dir] = true;
        q.add(new Node(startR, startC, dir));
        while(!q.isEmpty()){
            Node top = q.peek();
            q.remove();
          
            if(top.r == endR && top.c == endC){
                ans = cost[top.r][top.c][top.dir];
                break;
            }
            
            for(int i = 1; i <= 3; i++){
                int tempR = top.r + i*dr[top.dir];
                int tempC = top.c + i*dc[top.dir];
                if(!isFree(tempR, tempC)){
                    break;
                }
                if(!visited[tempR][tempC][top.dir]){
                    cost[tempR][tempC][top.dir] = cost[top.r][top.c][top.dir]  + 1;
                    q.add(new Node(tempR, tempC, top.dir));
                    visited[tempR][tempC][top.dir] = true;
                }
            }

            Node l = new Node(top.r,top.c,(top.dir+1)%4);
            Node r = new Node(top.r,top.c,(top.dir+3)%4);

            if(!visited[l.r][l.c][l.dir]){
                cost[l.r][l.c][l.dir] = cost[top.r][top.c][top.dir] + 1;
                visited[l.r][l.c][l.dir] = true;
                q.add(l);
            }

            if(!visited[r.r][r.c][r.dir]){
                cost[r.r][r.c][r.dir] = cost[top.r][top.c][top.dir] + 1;
                visited[r.r][r.c][r.dir] = true;
                q.add(r);
            }



        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){

            StringTokenizer st = new StringTokenizer(sc.nextLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m== 0){
                break;
            }
            map = new boolean[55][55];
            
            cost = new int[55][55][55];
            visited = new boolean[55][55][55];
          
            for(int i = 0; i < n; i++){
                String line = sc.nextLine();
                st = new StringTokenizer(line);
                for(int j = 0; j < m; j++){
                    if(st.nextToken().equals("1")){
                        map[i][j] = true;
                    }
                }
            }

            st = new StringTokenizer(sc.nextLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            if(s.equals("north")){
                dir = 0;
            }else if(s.equals("east")){
                dir = 1;
            }else if(s.equals("south")){
                dir = 2;
            }else{
                dir = 3;
            }
            int ans = findMinTime(startR, startC, endR, endC, dir);
            System.out.println(ans);
        }
    }
}