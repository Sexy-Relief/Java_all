//java file for BOJ PS
package boj_Solve;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.util.StringTokenizer;
public class bigint_prac {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        //String b = st.nextToken();
        a.trim();
        BigInteger bd=new BigInteger(a);
        BigInteger bd2=new BigInteger("20000303");
        System.out.println(bd.remainder(bd2));
    }
}