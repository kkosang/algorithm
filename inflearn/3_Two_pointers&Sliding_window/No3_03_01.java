import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [#2] 최대 매출
* */
public class No3_03_01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = slidingWindow(n, k, a);

        System.out.println(maxSum);
    }

    private static int slidingWindow(int n, int k, int[] a) {
        int sum = 0, maxSum = 0;
        // window size
        for (int i = 0; i < k; i++) sum += a[i];
        // sliding
        for (int i = k; i < n; i++) {
            sum += a[i] - a[i - k];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
