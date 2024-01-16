import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int wine[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            wine[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[n + 1];
        dp[1] = wine[1];
        if (n > 1)
            dp[2] = wine[1] + wine[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(wine[i] + dp[i - 2], dp[i - 1]);
            dp[i] = Math.max(dp[i], dp[i - 3] + wine[i] + wine[i - 1]);
        }

        System.out.println(dp[n]);
    }

}

