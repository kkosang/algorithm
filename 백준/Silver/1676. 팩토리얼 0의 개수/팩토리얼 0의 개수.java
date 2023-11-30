import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
뒷자리 0은 2와 5가 n개씩 짝일때 발생
https://st-lab.tistory.com/165
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int count = findTrailingZeros(n);
        System.out.println(count);
    }

    private static int findTrailingZeros(int n) {
        int count = 0;

        // n에서 5의 배수의 개수를 찾음
        for (int i = 5; i <= n; i *= 5) {
            count = count + n / i;
        }

        return count;
    }
}