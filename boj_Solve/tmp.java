//java file for BOJ PS
package boj_Solve;
//import java.util.*;

/*public class Main{
	public static void main(String args[]) {
		
	}
}*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class tmp {

    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new Integer[N];

        st = new StringTokenizer(br.readLine(), " ");

        // 배열에 숫자들을 넣어준다.
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //큰 숫자 순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        //M에 가까운 숫자 조합 가져오기
        int result = getLargeNumCombinations(M);
        System.out.print(result);
    }

    private static int getLargeNumCombinations(int max) {
        // 결과
        int result = 0;

        //제일 큰 두 값
        int most1;
        int most2;

        for(int j = 0; j < arr.length - 1; j++) {

            // 처음엔 제일 큰 두값이 0, 1 인덱스 지만,
            // 만약 큰 값을 발견하지 못하고 한 싸이클을 다시 돌게되면
            // 1씩 더해준다.
            most1 = arr[j];
            most2 = arr[j + 1];

            for(int i = j + 2; i < arr.length; i++) {
                // 셋이 합친값
                int sum = most1 + most2 + arr[i];

                //같거나 작으면 result return
                if(sum <= max) {
                    result = sum;
                    return result;
                }
            }

        }

        return result;
    }
}