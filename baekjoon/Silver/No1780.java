import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/* [#1] 종이의 개수
https://www.acmicpc.net/problem/1780
 * */
public class No1780 {

    static int[][] board;
    static int n, zero = 0, one = 0, minus = 0;
    static int A = 0, B = 0, C = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                board[i][j] = tmp;
            }
        }
        cnt(0, 0, n);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }

    static void cnt(int r, int c, int size) {
        zero = 0;
        one = 0;
        minus = 0;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] == 0) zero++;
                else if (board[i][j] == 1) one++;
                else minus++;
            }
        }

        if (minus != 0 && zero == 0 && one == 0) {
            A++;
        } else if (minus == 0 && zero != 0 && one == 0) {
            B++;
        } else if (minus == 0 && zero == 0 && one != 0) {
            C++;
        } else {
            int half = size / 3;
            // 왼쪽
            cnt(r, c, half);
            cnt(r, c + half, half);
            cnt(r, c + half * 2, half);
            // 가운데
            cnt(r + half, c, half);
            cnt(r + half, c + half, half);
            cnt(r + half, c + half * 2, half);
            // 아래
            cnt(r + half * 2, c, half);
            cnt(r + half * 2, c + half, half);
            cnt(r + half * 2, c + half * 2, half);
        }
    }
}

