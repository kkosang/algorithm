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

        int []a = new int[n+1];
         int [] dp = new int[n+1]; // 각 계단까지의 최대 점수
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = a[1];
        if(n>=2)
            dp[2] = a[1]+a[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + a[i] , dp[i-3] + a[i-1] + a[i]);
        }

        System.out.println(dp[n]);
    }
}
