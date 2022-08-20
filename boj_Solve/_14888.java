package boj_Solve;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14888{
	private static int n,idx;
	private static long maxv,minv;
	private static int a[]=new int[12];
	private static int op[]=new int[12];
	private static int opnum[]=new int[4];
	static int eval(int a,int b,int op) {
		switch(op) {
		case 0:
			return a+b;
		case 1:
			return a-b;
		case 2:
			return a*b;
		case 3:
			return a/b;
		}
		return 0;
	}
	static void back(int now) {
		if(now==n-1) {
			int val=eval(a[1],a[2],op[0]);
			for(int i=2;i<=n-1;i++) {
				val=eval(val,a[i+1],op[i-1]);
			}
			maxv=Math.max(val, maxv);
			minv=Math.min(val, minv);
		}
		for(int i=0;i<4;i++) {
			if(opnum[i]>0) {
				opnum[i]--;
				op[idx++]=i;
				back(now+1);
				idx--;
				opnum[i]++;
			}
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=n;i++) {
			a[i]=Integer.parseInt(tk.nextToken());
		}
		tk=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;i++) {
			opnum[i]=Integer.parseInt(tk.nextToken());
		}
		maxv=Long.MIN_VALUE;
		minv=Long.MAX_VALUE;
		back(0);
		System.out.println(maxv);
		System.out.println(minv);
	}
}