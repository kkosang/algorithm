import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int prime[] = new int[n + 1];
        int delete = 0;

        int count = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j = j + i) { // 배수 지우기
                if (prime[j] == 0) {
                    prime[j] = 1;
                    count++;
                    if (count == k) {
                        delete = j;
                    }
                }
            }
        }
        System.out.println(delete);
    }
}
