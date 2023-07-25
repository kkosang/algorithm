import java.util.Scanner;
import java.util.Stack;

/* [#1] 크레인 인형뽑기
https://cote.inflearn.com/contest/10/problem/05-03
* */
public class No5_03 {
    public static int solution(int n, int board[][], int m, int moves[]) {
        int answer = 0, j = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < m; i++) { // 기계 이동횟수
            j = 1;
            while (j < n && board[j][moves[i]] == 0) {
                j++;
            }
            if (!stack.isEmpty() && stack.peek() == board[j][moves[i]]) {
                answer += 2;
                stack.pop();
            } else {
                stack.push(board[j][moves[i]]);
            }
            board[j][moves[i]] = 0;

        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사이즈
        int board[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt(); // 인형뽑기 사이즈
        int moves[] = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(solution(n, board, m, moves));
    }
}

