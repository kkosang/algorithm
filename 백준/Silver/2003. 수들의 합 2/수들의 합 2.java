import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = 0;
        int sum = 0;
        int cnt = 0;

        while (true) {
            if (sum >= m) {
                sum -= a[lt++];
            } else if (rt >= n) {
                break;
            } else {
                sum += a[rt++];
            }

            if (sum == m) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
