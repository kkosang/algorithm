import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [#1] 상범 빌딩
-> E일때 큐에 넣지도 않고 병신이 E값을 찾으려함 !
https://www.acmicpc.net/problem/6593
* */

public class No6593 {

    static int H, R, C;
    static char building[][][];
    static int dz[] = {1, -1, 0, 0, 0, 0};
    static int dx[] = {0, 0, 0, 1, 0, -1};
    static int dy[] = {0, 0, 1, 0, -1, 0};
    static int sx, sy, sz;
    static int check[][][];
    static boolean flag;
    static int cnt;

    static class Node {
        int z;
        int x;
        int y;

        Node(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while (true) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (H == 0 && R == 0 && C == 0) {
                break;
            }
            check = new int[H][R][C];
            building = new char[H][R][C];
            flag = false;


            for (int i = 0; i < H; i++) {
                for (int j = 0; j < R; j++) {
                    String tmp = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char temp = tmp.charAt(k);
                        if (temp == 'S') {
                            sz = i;
                            sx = j;
                            sy = k;
                        }
                        building[i][j][k] = temp;
                    }
                }
                br.readLine();
            }

            bfs(0);

            if (flag) {
                System.out.println("Escaped in " + cnt + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }

    public static void bfs(int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sz, sx, sy)); // 시작점 집어넣기
        check[sz][sx][sy] = 1;
        cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                if (building[cur.z][cur.x][cur.y] == 'E') {
                    flag = true;
                    return;
                }
                for (int j = 0; j < 6; j++) { // 위아래
                    int nz = cur.z + dz[j];
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || ny < 0 || nz < 0 || nz >= H || nx >= R || ny >= C) continue;
                    if (check[nz][nx][ny] == 0 && (building[nz][nx][ny] == '.' || building[nz][nx][ny] == 'E')) {
                        check[nz][nx][ny] = 1;
                        q.add(new Node(nz, nx, ny));
                    }
                }
            }
            cnt++;
        }
    }
}
