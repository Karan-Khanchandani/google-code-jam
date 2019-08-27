package uva_solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class uva_11517 {
	
	// Oh well, the question is trying to fool you to do coin, but it is in fact a 0/1 knapsack problem. :P
	
    public static int [][] dp;
    static int N;
	public static boolean [][] flag;
	
	public static int query (int [] coin, int id, int remMoney) {
        if(id == 0)return 0;
        if(id == N) return -1;
        if(remMoney <= 0) return 0;
        if(dp[id][remMoney] != -1) return dp[id][remMoney];
        dp[id][remMoney] = Math.min(query(coin, id + 1, remMoney), query(coin, id, remMoney - coin[id]) + 1);
        return dp[id][remMoney];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int s=Integer.parseInt(br.readLine());
			 N=Integer.parseInt(br.readLine());
            int [] money=new int [N];
            dp=new int [N+1][10001];
			for (int [] dpS : dp) {
				Arrays.fill(dpS, -1);
			}
			for (int i=0;i<N;i++) {
                dp[i][0] = 0;
                money[i]=Integer.parseInt(br.readLine());
                dp[i][money[i]] = 1;
			}
			
			
			flag=new boolean [N+1][10001];
            
			for (int value=s;value<dp[N].length;value++) {
				if (query(money,0,value)!=-1) {
					System.out.println(value+" "+query(money,0,value));
					break;
				}
			}
		}
	}
}