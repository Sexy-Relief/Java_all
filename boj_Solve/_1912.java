package boj_Solve;
import java.util.*;
import java.io.*;
public class _1912{
	public static void main(String args[]) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxv,n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a=new int[n];
        int[] dp=new int[n];
        for(int i=0;i<n;i++)
        	a[i]=Integer.parseInt(st.nextToken());
        dp[0]=a[0];
        for(int i=1;i<n;i++)
        	dp[i]=dp[i-1]>0?dp[i-1]+a[i]:a[i];
        maxv=-1001;
        for(int i=0;i<n;i++)
        	maxv=Math.max(dp[i],maxv);
        System.out.println(maxv);
        
	}
}