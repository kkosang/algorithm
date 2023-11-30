import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 층
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 호수

            int people = calculatePeople(k, n);
            sb.append(people + "\n");
        }
        System.out.println(sb);
    }

    private static int calculatePeople(int k, int n) {
        int[][] apt = new int[k + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            apt[0][i] = i;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j]; // 옆집 + 아랫집
            }
        }
        return apt[k][n];
    }
}