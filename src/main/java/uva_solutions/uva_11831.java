package uva_solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class uva_11831{
    public static void main(String[] args) {
        int n, m, s;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0 && s == 0){
                break;
            }

            char[][] grid = new char[n][m];
            int startN = -1, startM = -1, currDir = -1;
            int DIR[][] = {{-1,0}, {0,1}, {1,0},{0,-1}};
            for(int i = 0 ; i < n; i++){
                grid[i] = sc.nextLine().toCharArray();
                for(int j = 0; j < m; j++){
                    if(grid[i][j] == 'N' || grid[i][j] == 'S' || grid[i][j] == 'L' || grid[i][j] == 'O'){
                        startM = j;
                        startN = i;
                        if(grid[i][j] == 'N'){
                            currDir = 0;
                        }else if(grid[i][j] == 'S'){
                            currDir = 2;
                        }else if(grid[i][j] == 'L'){
                            currDir = 1;
                        }else{
                            currDir = 3;
                        }
                    }
                }
            }

            String instructions = sc.nextLine();

            int stickers = 0;
            
            for(int i = 0; i < instructions.length(); i++){
                Character c = instructions.charAt(i);
                if(c == 'D'){
                    currDir = (currDir+1)%4;
                }else if(c == 'E'){
                    currDir = (currDir + 3)%4;
                }else{
                    int tempN = startN + DIR[currDir][0];
                    int tempM = startM + DIR[currDir][1];

                    if(tempM < 0 || tempM >= m || tempN < 0 || tempN >= n || grid[tempN][tempM] == '#'){

                    }else{
                        startN = tempN;
                        startM = tempM;
                        if(grid[startN][startM] == '*'){
                            stickers++;
                            grid[startN][startM] = '.';
                        }
                    }
                }
            }

            System.out.println(stickers);
        }
    }
}