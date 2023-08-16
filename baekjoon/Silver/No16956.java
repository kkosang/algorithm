import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [#1] 늑대와 양
https://www.acmicpc.net/problem/16956
* */
public class No16956 {

    static int R, C;
    static char[][] cage;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cage = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            int j = 0;
            for (char c : row.toCharArray()) {
                cage[i][j] = c;
                j++;
            }
        }

        boolean flag = true;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cage[i][j] == 'S') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                        if (cage[nx][ny] == 'W') {
                            flag = false;
                        } else if (cage[nx][ny] == '.') {
                            cage[nx][ny] = 'D';
                        }
                    }
                }

            }
        }

        if (flag) {
            System.out.println(1);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(cage[i][j]);
                }
                System.out.println();
            }

        } else {
            System.out.println("0");
        }
    }
}

