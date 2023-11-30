import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num[];
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[m]; // 뽑힌 값들

        combi(0, 1);
        System.out.println(sb);
    }

    public static void combi(int L, int start) {
        if (L == m) {
            for (int x : num)
                sb.append(x).append(' ');
            sb.append('\n');
        } else {

            for (int i = start; i <= n; i++) {
                num[L] = i;
                combi(L + 1, i + 1);
            }

        }
    }
}