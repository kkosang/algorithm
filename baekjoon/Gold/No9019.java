import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* [#1] DSLR
노드사용해서 , 연산값 저장해두기
Visited처리해서 시간복잡도 줄이기
https://www.acmicpc.net/problem/9019
* */
public class No9019 {
    static int T;

    public static class Node {
        int num;
        String s = "";

        Node(int num, String s) {
            this.num = num;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Node ans = BFS(A, B);
            System.out.println(ans.s);
        }
    }

    public static Node BFS(int A, int B) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, ""));
        boolean[] check = new boolean[10000];
        check[A] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.num == B) return cur;

            int num;
            // D
            num = (cur.num * 2) % 10000;
            if (!check[num]) {
                q.add(new Node(num, cur.s + "D"));
                check[num] = true;
            }

            // S
            num = cur.num - 1 < 0 ? 9999 : cur.num - 1;
            if (!check[num]) {
                q.add(new Node(num, cur.s + "S"));
                check[num] = true;
            }

            // L
            num = (cur.num % 1000) * 10 + cur.num / 1000;
            if (!check[num]) {
                q.add(new Node(num, cur.s + "L"));
                check[num] = true;
            }

            // R
            num = (cur.num % 10) * 1000 + cur.num / 10;
            if (!check[num]) {
                q.add(new Node(num, cur.s + "R"));
                check[num] = true;
            }
        }

        return null;
    }
}
