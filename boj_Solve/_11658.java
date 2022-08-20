package boj_Solve;
import java.util.*;
import java.io.*;
class Segtree_11658{
	private int[][] seg;
	private int n;
	Segtree_11658(int n){
		super();
		this.n=n;
		seg=new int[4*n][n];
	}
	public void make(int start,int end,int root,int[][] arr) {
		if(start==end) {
			seg[root]=arr[start];
			return;
		}
		int mid=(start+end)/2;
		make(start,mid,root*2,arr);
		make(mid+1,end,root*2+1,arr);
		for(int i=0;i<n;i++) {
			seg[root][i]=seg[root*2][i]+seg[root*2+1][i];
		}
	}
	public void upt(int start,int end,int root,int idxy,int idxx,int diff) {
		if(idxy<start||end<idxy)
			return;
		seg[root][idxx]+=diff;
		if(start==end) {			
			return;
		}
		int mid=(start+end)/2;
		upt(start,mid,root*2,idxy,idxx,diff);
		upt(mid+1,end,root*2+1,idxy,idxx,diff);
	}
	public int query(int start,int end,int root,int lowy,int lowx,int highy,int highx) {
		if(highy<start||end<lowy)
			return 0;
		if(lowy<=start&&end<=highy){
			int cnt=0;
			for(int i=lowx;i<=highx;i++) {
				cnt+=seg[root][i];
			}
			return cnt;
		}
		int mid=(start+end)/2;
		return query(start,mid,root*2,lowy,lowx,highy,highx)+query(mid+1,end,root*2+1,lowy,lowx,highy,highx);
	}
}
public class _11658{
	public static void main(String args[]) throws IOException {
		int n,m,tmp,a,b,c,d;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		StringBuilder sb=new StringBuilder();
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		Segtree_11658 sg=new Segtree_11658(n+1);
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=n;j++) {
				tmp=Integer.parseInt(st.nextToken());
				sg.upt(1,n,1,i,j,tmp);
			}
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			tmp=Integer.parseInt(st.nextToken());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			if(tmp==0) {
				sg.upt(1,n,1,a,b,c-sg.query(1, n, 1, a, b, a, b));
			}
			else {
				d=Integer.parseInt(st.nextToken());
				sb.append(sg.query(1,n,1,a,b,c,d));
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}
}