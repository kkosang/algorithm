import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[n];
        int ans = a[0];
        dp[0] = a[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+a[i] , a[i]);
            ans = Math.max(dp[i],ans);
        }

        System.out.println(ans);
    }
}
