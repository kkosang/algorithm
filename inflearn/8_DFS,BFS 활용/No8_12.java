import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [#1] 토마토 (BFS활용)
https://cote.inflearn.com/contest/10/problem/08-12
 * */
public class No8_12 {

    static int[][] box;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;

    static class Start {
        int x;
        int y;

        Start(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Start> q = new LinkedList<>();

    public static void bfs() {
        int L = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Start cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 범위 벗어남
                    if (box[nx][ny] == 0) {
                        q.add(new Start(nx, ny));
                        box[nx][ny] = 1;
                    }
                }
            }
            L++;
        }
        boolean flag = isFlag();
        if (flag) System.out.println(L - 1); // 전부 익음
        else System.out.println(-1); // 익지 못하는 상황
    }

    public static boolean isFlag() {
        boolean answer = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        boolean loop = false;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.add(new Start(i, j));
                }
                if (box[i][j] == 0 && !loop) loop = true; // 안익은게 나옴
            }
        }
        if (loop) {
            bfs();
        } else { // 모두 익어있음
            System.out.println(0);
        }
    }
}

