import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int n, m;
    static int maze[][];
    static boolean visited[][];
    static int distance[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];


        // input
        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                if (maze[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        BFS(startX, startY);

        //output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maze[i][j] == 1) sb.append(-1 + " ");
                else sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void BFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!visited[nx][ny] && maze[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[cur.x][cur.y] + 1;
                }
            }
        }
    }

    public static class Node {
        int x, y;

        Node(int x, int y) { // 생성자
            this.x = x;
            this.y = y;
        }
    }
}