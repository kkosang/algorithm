import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [#0] 친구인가 (Union & Find)
https://cote.inflearn.com/contest/10/problem/09-06
 * */
public class No9_06 {
    static int[] unf;

    public static int Find(int v) {
        if (v == unf[v]) return v; // 이미 같은 값이면 바로 반환
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb; // 둘이 친구가 아니면
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생수
        int m = Integer.parseInt(st.nextToken()); // 숫자쌍
        unf = new int[n + 1]; // idx : 학생, 배열값 : 집합

        for (int i = 1; i <= n; i++) unf[i] = i; // 각 학생들은 자기자신과 집합임
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 친구1
            int b = Integer.parseInt(st.nextToken()); // 친구2
            Union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) System.out.println("NO");
        else System.out.println("YES");
    }
}
