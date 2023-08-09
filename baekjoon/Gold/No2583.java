import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* [#1] 영역 구하기
https://www.acmicpc.net/problem/2583
* */
public class No2583 {
    static int n;
    static int m;
    static int k;
    static int board[][];
    static int cnt;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // m은 행
        // n 은 열
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[m][n];

        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x1, y1;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            int x2, y2;
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    board[j][l] = 1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                if (board[i][j] == 0) {
                    DFS(i, j);
                    result.add(cnt + 1);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result) System.out.print(x + " ");
    }

    static void DFS(int x, int y) {
        board[x][y] = 1;

        for (int t = 0; t < 4; t++) {
            int nx = x + dx[t];
            int ny = y + dy[t];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && board[nx][ny] == 0) {
                cnt++;
                DFS(nx, ny);
            }
        }
    }
}

