import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* [#1] 세 용액
투포인터 사용하기 위해서는 정렬
투포인터의 응용-> p는 for문으로 하나씩 늘려감, q는 (p+1), r는 (길이-1)로 잡고 투포인터 돌림
https://www.acmicpc.net/problem/2473
* */
public class No2473 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 용액 개수 N
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // -99 -2 -1 4 98

        int idx1 = 0, idx2 = 1, idx3 = 2;
        int p = 0, q = p + 1, r = N - 1;
        long max = Long.MAX_VALUE;

        while (p < r - 1) {
            //System.out.println(p + " " + q + " " + r);
            while (q < r) {
                long sum = (long) arr[p] + arr[q] + arr[r];
                long abs = Math.abs(sum);

                if (max > abs) {
                    idx1 = p;
                    idx2 = q;
                    idx3 = r;
                    max = abs;
                }

                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    q++;
                } else { // 0
                    break;
                }
            }
            p++;
            q = p + 1;
            r = N - 1;
        }

        System.out.println(arr[idx1] + " " + arr[idx2] + " " + arr[idx3]);
    }
}
