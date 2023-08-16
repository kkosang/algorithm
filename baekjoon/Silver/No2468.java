import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [#2] 안전 영역
https://www.acmicpc.net/problem/2468
* */

public class No2468 {
    static int n,max_h;
    static boolean[][] visited;
    static int[][] graph;
    static int max;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        max_h = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] > max_h) {
                    max_h = graph[i][j];
                }
            }
        }

        max = -1;
        for (int h = 0; h <= max_h; h++) {
            visited = new boolean[n][n]; // 방문처리 초기화
            int cnt = 0;
            // 안전한곳 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && graph[i][j] > h) { // 방문하지 않았고, 현재 높이보다 높은경우
                        cnt += DFS(h, i, j);
                    }
                }
            }

            max = Math.max(max, cnt); // 최댓값 함수
        }
        System.out.println(max);
    }

    public static int DFS(int h, int x, int y) {
        visited[x][y] = true; // 방문체크

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // 테두리
            if (visited[nx][ny]) continue; // 방문
            if (graph[nx][ny] > h) { // 높이가 더 높은곳이면 탐색
                DFS(h, nx, ny);
            }
        }
        return 1;
    }
}

