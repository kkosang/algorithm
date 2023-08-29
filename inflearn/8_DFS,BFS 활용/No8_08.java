import java.util.Scanner;

/* [#0] 수열 추측하기
https://cote.inflearn.com/contest/10/problem/08-08
 * */
public class No8_08 {

    static int[] comb, perm, ch; // 조합,순열,체크배열
    static int n, f;
    static boolean flag = false;
    static int[][] dp = new int[35][35];

    public static int combination(int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];
        if (n == r || r == 0) return 1;
        else return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public static void dfs(int L, int sum) {
        if (flag) return;
        if (L == n) { // 순열 완성
            if (sum == f) {
                for (int x : perm) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) { // i자체가 순열을 만듬
                if (ch[i] == 0) {
                    ch[i] = 1;
                    perm[L] = i;
                    dfs(L + 1, sum + (perm[L] * comb[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();

        comb = new int[n];
        perm = new int[n];
        ch = new int[n + 1]; // 숫자를 1부터 사용

        for (int i = 0; i < n; i++) { // n-1Cr
            comb[i] = combination(n - 1, i);
        }
        dfs(0, 0);
    }
}

