import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* [#0] 연구소
-> 벽 세우기
-> 벽설치하면서, for문 돌다가 x,y부터 시작하면 재귀 돌때 행으로 이동할때, 반복x하려다가 실패함
https://www.acmicpc.net/problem/14502
https://bbangson.tistory.com/57
 * */
public class No14502 {

    static int[][] board, clone;
    static int n, m, max;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Point> list = new ArrayList<>();

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void wall(int cnt, int s) {
        if (cnt == 3) {
            bfs();
            max = Math.max(max, safeZone());
        } else {
            for (int i = s; i < n * m; i++) { // 2차원배열 -> 1차원
                int dx = i / m;
                int dy = i % m;
                if(board[dx][dy] == 2 || board[dx][dy] == 1) continue;
                board[dx][dy] = 1; // 벽 설치
                wall(cnt+1,i+1);
                board[dx][dy] = 0; // 백트레킹
            }
        }
    }

    static void cloneBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                clone[i][j] = board[i][j];
            }
        }
    }

    static int safeZone() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (clone[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    static void bfs() {
        cloneBoard();

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) { // 바이러스 시작점 큐에 넣기
            q.add(new Point(list.get(i).x, list.get(i).y));
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (clone[nx][ny] == 0) {
                    clone[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        clone = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2)
                    list.add(new Point(i, j));
                board[i][j] = tmp;
            }
        }

        max = Integer.MIN_VALUE;

        wall(0, 0);

        System.out.println(max);
    }
}

