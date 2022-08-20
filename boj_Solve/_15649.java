package boj_Solve;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15649{
	private static int n,m,idx;
	private static int l[]=new int[10];
	private static boolean v[]=new boolean[10];
	private static StringBuilder sb=new StringBuilder();
	static void back(int now) {
		if(now==m){
			for(int i=0;i<idx;i++)
				sb.append(l[i]).append(' ');
			sb.append('\n');
			return;
		}
		for(int i=1;i<=n;i++) {
			if(!v[i]) {
				v[i]=true;
				l[idx++]=i;
				back(now+1);
				idx--;
				v[i]=false;
			}
		}
		
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(tk.nextToken());
		m=Integer.parseInt(tk.nextToken());
		back(0);
		System.out.println(sb);
	}
}