import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [#0] 사다리 조작
-> 감도 안옴 , 0: 해당칸에는 가로선 x  1: 해당칸을 기준으로 우측연결 가로선, 2: 해당칸을 기준으로 좌측 연결 가로선
https://www.acmicpc.net/problem/15684
https://pangtrue.tistory.com/282
* */
public class No15684 {

    static int width, height, M, ans;
    static int[][] ladder;
    static boolean isFinish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 연결된 가로선의 갯수
        height = Integer.parseInt(st.nextToken());
        ladder = new int[height + 1][width + 1];

        for (int i = 0; i < M; i++) { // 가로선의 개수만큼
            // s의 높이에서 e와 e+1 세로선 연결
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ladder[s][e] = 1; // 우측으로 이동
            ladder[s][e + 1] = 2; // 좌측으로 이동
        }

        for (int i = 0; i <= 3; i++) {
            ans = i; // 추가한 가로선 갯수
            dfs(1, 1, 0);
            if (isFinish) break;
        }
        System.out.println(isFinish ? ans : -1);
    }

    public static void dfs(int x, int y, int addLine) {
        if (isFinish) return;
        if (ans == addLine) {
            if (check()) isFinish = true;
            return;
        }

        for (int i = y; i <= height; i++) {
            for (int j = x; j < width; j++) {
                if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) { // 사다리가 없는경우
                    ladder[i][j] = 1;
                    ladder[i][j + 1] = 2;

                    dfs(1, 1, addLine + 1);

                    // 백트래킹 , 추가했던 가로선 제거
                    ladder[i][j] = 0;
                    ladder[i][j + 1] = 0;
                }
            }
        }
    }

    // i번으로 출발해서 i번으로 도착하는지 확인
    public static boolean check() {
        for (int i = 1; i <= width; i++) {
            int nx = i;
            int ny = 1;

            while (ny <= height) {
                if (ladder[ny][nx] == 1) nx++; // 우측이동
                else if (ladder[ny][nx] == 2) nx--; // 좌측이동
                ny++; // 아래로 이동
            }
            if (nx != i) return false; // 도착하지 않는다면
        }
        return true; // 도착
    }
}

