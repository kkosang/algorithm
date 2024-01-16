import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] maze;
    public static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) continue;
                int move = maze[i][j];
                if (j + move < n)
                    dp[i][j + move] += dp[i][j];
                if (i + move < n)
                    dp[i + move][j] += dp[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }

}

