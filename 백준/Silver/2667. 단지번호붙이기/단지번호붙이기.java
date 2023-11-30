import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int home[][];
    static boolean visited[][];
    static int n;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        home = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                home[i][j] = input.charAt(j) - '0';
            }
        }

        int count = 0;
        ArrayList<Integer> eachHomeCount = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && home[i][j] == 1) {
                    eachHomeCount.add(BFS(i, j));
                    count++;
                }
            }
        }

        Collections.sort(eachHomeCount);
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for (int i : eachHomeCount)
            sb.append(i).append("\n");
        System.out.println(sb);
    }

    public static int BFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x, y));

        int size = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (home[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
            size++;
        }

        return size; // 집의 수
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
