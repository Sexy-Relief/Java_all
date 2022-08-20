package boj_Solve;
import java.util.*;
import java.io.*;

public class _9426{
	private static int n,k;
	private static int[] a=new int[250001];
	private static long ans=0;
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		Segtree sg=new Segtree(65537);
		for(int i=1;i<=n;i++) {
			a[i]=Integer.parseInt(br.readLine().trim());
			sg.upt(0, 65536, 1, a[i], 1);
			if(i<k) continue;
			int tmp=sg.bin_search(0,65536,(k+1)/2);
			ans+=tmp;
			sg.upt(0,65536,1,a[i-k+1],-1);
		}
		System.out.println(ans);
	}
}