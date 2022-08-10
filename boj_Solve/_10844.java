package boj_Solve;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//import
public class _10844{
	static long[][] dp=new long[10][101];
	static long func(int k,int n) {
		if(n<=0||k>9||k<0)
			return 0;
		if(dp[k][n]!=-1)
			return dp[k][n];
		dp[k][n]=(func(k+1,n-1)+func(k-1,n-1))%1_000_000_000;
		return dp[k][n];
		
	}
	public static void main(String args[]) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long tmp=0;
		for(int i=0;i<10;i++)
			Arrays.fill(dp[i],-1);
		for(int i=1;i<10;i++)
			dp[i][1]=1;
		dp[1][2]=1;
		for(int i=0;i<10;i++) {
			tmp+=func(i,n);
		}
		tmp%=1_000_000_000;
		System.out.println(tmp);
	}
}