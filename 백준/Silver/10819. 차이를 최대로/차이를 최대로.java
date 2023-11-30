import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] num;
    static int[] ans;
    static boolean[] visited;
    static int n, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        visited = new boolean[n];
        ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        combi(0);
        System.out.println(max);
    }

    public static void combi(int L) {
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(ans[i] - ans[i + 1]);
            }
            max = Math.max(max, sum);
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {

                    ans[L] = num[i];
                    visited[i] = true;
                    combi(L + 1);
                    visited[i] = false;

                }
            }
        }
    }
}
