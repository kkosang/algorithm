import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int cost[][] = new int[n + 1][3]; // n개의 집을 R,G,B로 칠하는 비용

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int dp[][] = new int[n + 1][3]; // dp배열
        for (int i = 0; i < 3; i++) {
            dp[1][i] = cost[1][i]; // 첫번째 집을 R,G,B로 칠하는 비용
        }

        // 2번째 집부터 n번째 집까지 dp 갱신
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0]; // 현재집을 R로 칠하는 비용
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1]; // 현재집을 G로 칠하는 비용
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2]; // 현재집을 B로 칠하는 비용
        }

        // 마지막까지 전부 칠하고 최솟값 찾기
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, dp[n][i]);
        }

        System.out.println(answer);
    }
}
