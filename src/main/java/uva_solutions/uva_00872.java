package uva_solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class uva_00872 {
	
	public static boolean [][] prohibited;
	public static char [] c;
	public static ArrayList<String> ans;
	public static boolean [] flag;
	
	public static boolean isAllowed(char [] taken, int takenCount, char toTest) {
		boolean flag=true;
		for (int i=0;i<takenCount && flag;i++) {
			flag=!prohibited[taken[i]][toTest];
		}
		return flag;
	}
	
	public static void search (char [] taken, int takenCount) {
		if (c.length==takenCount) {
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<takenCount;i++) {
				sb.append(taken[i]);
				if (i<takenCount-1) {
					sb.append(" ");
				}
			}
			ans.add(sb.toString());
		} else {
			for (int i=0;i<c.length;i++) {
				if (!flag[i] && isAllowed(taken,takenCount,c[i])) {
					flag[i]=true;
					taken[takenCount]=c[i];
					search(taken,takenCount+1);
					flag[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine(); //blank!
			
			prohibited=new boolean [128][128];
			StringTokenizer st=new StringTokenizer(br.readLine());
			c=new char [st.countTokens()];
			for (int i=0;i<c.length;i++) {
				c[i]=st.nextToken().charAt(0);
			}
			
			st=new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				String s=st.nextToken();
				char dest=s.charAt(0);
				char src=s.charAt(2);
				prohibited[src][dest]=true;
			}
			
			ans=new ArrayList<>();
			flag=new boolean [c.length];
			search(new char [c.length],0);
			
			if (testCase>0) {
				System.out.println();
			}
			
			if (ans.size()==0) {
				System.out.println("NO");
			} else {
				for (int i=0;i<ans.size();i++) {
					System.out.println(ans.get(i));
				}
			}
		}
	}
}