import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int idx = 0;

        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (max < num) {
                max = num;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx);
    }
}