package boj_Solve;
class Segtree{
	private int[] seg;
	private int n;
	Segtree(int n){
		super();
		this.n=n;
		seg=new int[4*n];
	}
	public void make(int start,int end,int root,int[] arr) {
		if(start==end) {
			seg[root]=arr[start];
			return;
		}
		int mid=(start+end)/2;
		make(start,mid,root*2,arr);
		make(mid+1,end,root*2+1,arr);
		seg[root]=seg[root*2]+seg[root*2+1];
	}
	public void upt(int start,int end,int root,int idx,int diff) {
		if(idx<start||end<idx)
			return;
		seg[root]+=diff;
		if(start==end) {			
			return;
		}
		int mid=(start+end)/2;
		upt(start,mid,root*2,idx,diff);
		upt(mid+1,end,root*2+1,idx,diff);
	}
	public int query(int start,int end,int root,int low,int high) {
		if(high<start||end<low)
			return 0;
		if(low<=start&&end<=high)
			return seg[root];
		int mid=(start+end)/2;
		return query(start,mid,root*2,low,high)+query(mid+1,end,root*2+1,low,high);
	}
	//start~end의 인덱스 범위에서 val번째 원소는 배열의 몇번째 인덱스에 있는지를 구하는 함수
	public int bin_search(int start,int end,int val) {
		int mid=1;
		while(start<=end) {
			mid=(start+end)/2;
			int tmp1=start<mid?query(0,n-1,1,0,mid-1):0;
			int tmp2=query(0,n-1,1,0,mid);
			if(tmp1<val&&tmp2>=val) {
				break;
			}
			else if(tmp2<val) {
				start=mid+1;
			}
			else if(tmp1>=val) {
				end=mid;
			}
		}
		return mid;
	}
}