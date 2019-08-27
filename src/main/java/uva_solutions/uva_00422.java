package uva_solutions;

import java.util.Scanner;

public class uva_00422{
    static int dr[] = {-1, 0, 1, 1, 1, 0,-1};
    static int dc[] = {-1,-1,-1, 0, 1, 1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[][] grid = new char[n][n];
        for(int i = 0; i < n; i++){
            grid[i] = sc.nextLine().toCharArray();
        }
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("0")){
                break;
            }
            char[] P = line.toCharArray();
            boolean found = false;
            int rs = 0, cs = 0, re = 0, ce = 0;
            for(int i = 0; i < n && !found ; i++){
                for(int j = 0; j < n && !found; j++){
                    for(int d = 0; d < 7; d++){
                        found = true;
                        int nk = 0;
                        for(int k = 0; k < P.length; k++){
                            int ni = i + k*dr[d];
                            int nj = j + k*dc[d];
                            if(ni < 0 || ni >= n || nj < 0 || nj >= n || grid[ni][nj] != P[k]){
                                found = false;
                                break;
                            }
                            nk = k;
                        }

                        if(found){
                            rs = i +1;
                            cs = j+1;
                            re = i + nk*dr[d] + 1;
                            ce = j+ nk*dc[d] + 1;
                            break;
                        }
                    }
                }
            }

            if(found){
                System.out.println(rs + "," + cs + " " + re + "," + ce);
            }else{
                System.out.println("Not found");
            }
        }
        sc.close();
        System.exit(0);

    }
}