import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n, s;
    static int arr[];
    static boolean visited[];
    static int answer = 0; // 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 부분 수열의 사이즈가 1부터 n까지
        for (int i = 1; i <= n; i++) {
            combi(1, i, 0);
        }

        System.out.println(answer);
    }

    public static void combi(int start, int size, int sum) {
        if (size == 0) {
            if (sum == s) answer++;
            return;
        }

        for (int i = start; i <= n; i++) { // 사이즈만큼 배열 완성
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, size - 1, sum + arr[i]);
                visited[i] = false;
            }
        }

    }

}
