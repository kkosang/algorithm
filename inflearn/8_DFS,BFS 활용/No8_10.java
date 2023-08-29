import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/* [#1] 미로탐색
https://cote.inflearn.com/contest/10/problem/08-10
 * */
public class No8_10 {

    static int[][] maze, visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cnt = 0;

    public static void dfs(int x, int y) {
        if (x == 7 && y == 7) { // 도착지점 도착
            cnt++;
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx > 7 || ny > 7 || nx < 1 || ny < 1) continue;
                if (visited[nx][ny] == 0 && maze[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    dfs(nx, ny);
                    visited[nx][ny] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        maze = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[8][8];
        visited[1][1] = 1;
        dfs(1, 1);

        System.out.println(cnt);
    }
}

