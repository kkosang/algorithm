import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* [#1] 숫자판 점프
https://www.acmicpc.net/problem/2210
 * */
public class No2210 {

    static int[][] board = new int[5][5];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static HashSet<Integer> set = new HashSet<>();
    static int[] num = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                board[i][j] = tmp;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(0, i, j);
                num[0] = board[i][j];
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int L, int i, int j) {
        if (L == 6) {
            int tmp = 0, ten = 1;
            for (int x : num) {
                tmp = tmp + x * ten;
                ten *= 10;
            }
            set.add(tmp);
        } else {
            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                num[L] = board[nx][ny];
                dfs(L + 1, nx, ny);
            }
        }
    }
}

