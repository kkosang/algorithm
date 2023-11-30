import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int answer[];
    static ArrayList<Integer> useNum = new ArrayList<>();
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m]; // 뽑아야 할 값
        visited = new boolean[n]; // 중복사용체크

        // 사용할 숫자 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            useNum.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(useNum);

        combi(0);
        System.out.println(sb);
    }

    public static void combi(int L) {
        if (L == m) {
            for (int x : answer)
                sb.append(x).append(' ');
            sb.append('\n');
        } else {

            for (int i = 0; i < n; i++) { // 사용할 숫자 선택
                if (!visited[i]) {
                    answer[L] = useNum.get(i);

                    visited[i] = true;
                    combi(L + 1);
                    visited[i] = false;
                }
            }

        }
    }
}