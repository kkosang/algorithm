import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
돌다리 건너기 https://cote.inflearn.com/contest/10/problem/10-02
* */

public class No10_02 {
    static int[] dp;
    static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 2];

        dp[1] = 1; // 첫번째 계단까지 올라갈 수 있는 방법
        dp[2] = 2; // 두번째 계단까지 올라갈 수 있는 방법

        for (int i = 3; i <= n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[n + 1]);
    }
}


