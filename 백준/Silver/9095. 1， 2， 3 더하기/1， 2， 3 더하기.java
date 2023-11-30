import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            count = 0;
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            sumOneTwoThree(0);
            System.out.println(count);
        }
    }

    public static void sumOneTwoThree(int sum) {
        if (sum == num) {
            count++;
            return;
        }

        if (sum > num) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            sumOneTwoThree(sum + i);
        }
    }
}
