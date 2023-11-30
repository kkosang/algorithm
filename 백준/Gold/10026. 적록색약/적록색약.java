import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};
    static char grid[][];
    static boolean check[][];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new char[n][n];
        check = new boolean[n][n];

        // grid입력 받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // 적록색약이 아닐 때
        int count = countRegions(false);
        System.out.print(count + " ");

        // 초기화 후 적록색약일 때
        count = countRegions(true);
        System.out.println(count);
    }

    public static int countRegions(boolean colorWeak) {
        if (colorWeak) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'G') {
                        grid[i][j] = 'R';
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    BFS(i, j);
                    count++;
                }
            }
        }

        // check 배열 초기화
        check = new boolean[n][n];
        return count;
    }

    public static void BFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        char color = grid[x][y];
        check[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (!check[nx][ny] && grid[nx][ny] == color) {
                    q.add(new Node(nx, ny));
                    check[nx][ny] = true;
                }
            }
        }
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