import java.util.Scanner;

/* 격자판 최대합
https://cote.inflearn.com/contest/10/problem/02-09
* */
public class No2_09 {
    public static int solution(int n, int arr[][]) {
        int answer = 0;

        int rowSum = 0, colSum = 0, crossSum1 = 0, crossSum2 = 0;

        for (int i = 0; i < n; i++) {
            rowSum = colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            crossSum1 += arr[i][i];
            crossSum2 += arr[n - i - 1][i];

            int tmp = Math.max(rowSum, colSum);
            answer = Math.max(tmp, answer);
        }
        int tmp = Math.max(crossSum1, crossSum2);
        answer = Math.max(tmp, answer);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}

