import java.util.Scanner;

/* [#1] 조합의 경우수 (메모이제이션)
nCr = n-1Cr-1 + n-1Cr => 하나의 수를 참여하고 나머지 뽑고, 참여하지 않고 뽑고
https://cote.inflearn.com/contest/10/problem/08-07
 * */
public class No8_07 {

    static int n, r;
    static int[][] dp;

    public static int dfs(int m, int k) {
        if (dp[m][k] > 0) return dp[m][k];

        if (m == k || k == 0) {
            return 1;
        }
        return dp[m][k] = dfs(m - 1, k - 1) + dfs(m - 1, k);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        dp = new int[n + 1][r + 1];
        System.out.println(dfs(n,r));
    }
}

