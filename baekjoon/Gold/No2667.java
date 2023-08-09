import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* [#1] 단지번호붙이기
https://www.acmicpc.net/problem/2667
* */
public class No2667 {
    static int n;
    static int board[][];
    static int cnt;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String num = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(num.charAt(j)));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                if (board[i][j] == 1) {
                    DFS(i, j);
                    result.add(cnt + 1);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result) System.out.println(x);
    }

    static void DFS(int x, int y) {
        board[x][y] = 0;

        for (int t = 0; t < 4; t++) {
            int nx = x + dx[t];
            int ny = y + dy[t];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 1) {
                cnt++;
                DFS(nx, ny);
            }
        }
    }
}

