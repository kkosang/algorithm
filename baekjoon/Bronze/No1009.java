import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [#1] 분산처리
-> 10으로 나누어 떨어지는 경우
https://www.acmicpc.net/problem/1009
* */
public class No1009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int data = 1;
            for (int j = 1; j <= b; j++) {
                if (data * a % 10 == 0) {
                    data = 10;
                } else {
                    data = data * a % 10;
                }
            }
            sb.append(data + "\n");
        }
        System.out.println(sb);
    }
}

