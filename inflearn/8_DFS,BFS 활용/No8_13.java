import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [#2] 섬나라 아일랜드 (DFS / BFS)
https://cote.inflearn.com/contest/10/problem/08-13
 * */
public class No8_13 {

    static int[][] island, visited;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int N;

    static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (island[nx][ny] == 1 && visited[nx][ny] == 0) {
                visited[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        island = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (island[i][j] == 1 && visited[i][j] == 0) { // 1 이면 탐색시작
                    visited[i][j] = 1;
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

/*
*   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        island = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (island[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void bfs(int x, int y) {
        Queue<XY> q = new LinkedList<>();
        q.add(new XY(x, y));
        while (!q.isEmpty()) {
            XY cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (island[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    q.add(new XY(nx, ny));
                }
            }
        }
    }

    static class XY {
        int x;
        int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
* */