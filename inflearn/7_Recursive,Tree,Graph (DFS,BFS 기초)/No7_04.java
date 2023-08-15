import java.util.Scanner;

/* [#1] 피보나지 재귀 (메모이제이션)
 * */
public class No7_04 {
    static int[] memo;

    public static void solution(int n) {
        for (int i = 1; i <= n; i++) { // 1부터 n까지의 항 반복
            System.out.print(fibo(i) + " ");
        }
    }

    public static int fibo(int n) {
        if (memo[n] > 0) return memo[n]; // 0보다크다 -> 이미 구한 값임 -> 반환
        if (n == 1) return memo[n] = 1;
        else if (n == 2) return memo[n] = 1;
        else {
            return memo[n] = fibo(n - 2) + fibo(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n + 1];
        solution(n);
    }
}

