import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [#1] 부분집합 구하기(DFS)
 * */
public class No7_06 {
    static int n;
    static int ch[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        ch = new int[n + 1]; // 체크배열 (사용여부 1-> 사용, 0->미사용)
        DFS(1);
    }

    public static void DFS(int L) {
        if (L == n + 1) { // 깊이탐색이 끝난 경우
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) tmp += (i + " ");
            }
            // 공집합 제외하고 출력
            if (tmp.length() > 0) System.out.println(tmp);

        } else {
            // 왼쪽으로 뻗기 -> 사용
            ch[L] = 1;
            DFS(L + 1);

            // 오른쪽으로 뻗기 -> 미사용
            ch[L] = 0;
            DFS(L + 1);
        }
    }

}


