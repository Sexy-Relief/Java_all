package boj_Solve;
import java.io.*;
import java.util.*;
public class _9375{
	private static int t,n,cnt;
	private static StringBuilder sb=new StringBuilder();
	private static StringTokenizer st=null;
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> hm=new HashMap<>();
		t=Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			cnt=1;
			n=Integer.parseInt(br.readLine().trim());
			for(int j=0;j<n;j++) {
				st=new StringTokenizer(br.readLine()," ");
				st.nextToken();
				String s=st.nextToken();
				if(hm.containsKey(s))
					hm.put(s,hm.get(s)+1);
				else
					hm.put(s,1);
			}
			Collection<Integer> c=hm.values();
			for(Integer k:c)
				cnt*=(k+1);
			sb.append(--cnt).append('\n');
			hm.clear();
		}
		System.out.println(sb);
	}
}