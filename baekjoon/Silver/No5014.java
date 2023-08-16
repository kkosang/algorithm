import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [#1] 스타트링크
-> 레벨별로 나누기, 0층 간과
https://www.acmicpc.net/problem/5014
* */
public class No5014 {
    static int F, S, G;
    static int u, d;
    static int cnt = 0;
    static boolean check[];
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 총 f층
        S = Integer.parseInt(st.nextToken()); // 강호 s층
        G = Integer.parseInt(st.nextToken()); // 스타트링크 G층
        u = Integer.parseInt(st.nextToken()); // 위로버튼
        d = Integer.parseInt(st.nextToken()); // 아래로 버튼
        //System.out.println(F+" "+S+" "+G+" "+u+" "+d);
        check = new boolean[F + 1];
        BFS(S);

        if (flag)
            System.out.println(cnt);
        else
            System.out.println("use the stairs");
    }

    public static void BFS(int S) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S); // 현재층
        check[S] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) { // 레벨별로 나누기
                int cur = queue.poll(); // 현재 층 수 꺼내고
                if (cur == G) {
                    flag = true;
                    return;
                }
                int nu = cur + u;
                int nd = cur - d;
                if (nu <= F && !check[nu]) {
                    check[nu] = true;
                    queue.add(nu);
                }
                if (nd >= 1 && !check[nd]) {
                    check[nd] = true;
                    queue.add(nd);
                }
            }
            cnt++;
        }
    }
}

