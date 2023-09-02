import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [#0] 숨바꼭질2
2,2가 같은 레벨에 있으면 들어가야함 -> 큐에서 뺄때 방문처리
https://www.acmicpc.net/problem/12851
* */
public class No12851 {
    static int n, k;
    static int min = Integer.MAX_VALUE, cnt = 0;
    static int dy[] = {-1, 1, 2};
    static int check[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(n - k);
            System.out.println(1);
        } else {
            bfs(n, k);
            System.out.println(min);
            System.out.println(cnt);
        }
    }

    static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        int nx = 0;
        int L = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                check[cur] = 1;
                if (cur == k && min >= L) {
                    cnt++;
                    min = L;
                }
                for (int j = 0; j < 3; j++) { // 다음큐에 넣을 것
                    if (j == 2) {
                        nx = cur * dy[j];
                    } else {
                        nx = cur + dy[j];
                    }

                    if (nx < 0 || nx > 100000) continue;
                    if (check[nx] == 0) {
                        q.add(nx);
                    }
                }
            }
            L++;
        }
    }
}

