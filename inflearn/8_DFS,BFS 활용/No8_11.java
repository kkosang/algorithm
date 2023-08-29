import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [#2] 미로탐색
1) 도착지점 만났을 때 -> 종료
2) dis배열 이용
https://cote.inflearn.com/contest/10/problem/08-11
 * */
public class No8_11 {

    static int[][] maze, dis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class XY {
        int x;
        int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {
        Queue<XY> q = new LinkedList<>();
        maze[x][y] = 1;
        q.add(new XY(1, 1));

        while (!q.isEmpty()) {
            XY cur = q.poll();

            for (int j = 0; j < 4; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];
                if (nx > 7 || ny > 7 || nx < 1 || ny < 1) continue;
                if (maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    q.add(new XY(nx, ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1; // 이동한좌표의 값은 현재 값 + 1
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        maze = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(1, 1);
        if (dis[7][7] != 0) System.out.println(dis[7][7]);
        else System.out.println(-1);
    }
}

