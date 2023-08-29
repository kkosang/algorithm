import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [#0] 피자 배달 거리 ( 삼성 DFS활용 )
https://cote.inflearn.com/contest/10/problem/08-14
 * */
public class No8_14 {

    static ArrayList<XY> home, pizza;
    static int[] combi;
    static int N, M, len, answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        pizza = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1)
                    home.add(new XY(i, j));
                if (tmp == 2)
                    pizza.add(new XY(i, j));
            }
        }
        len = pizza.size();
        combi = new int[M]; // M개의 조합 -> lenCm
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int L, int s) {
        if (L == M) { // 조합완성
            int sum = 0; // 도시의 피자 배달거리
            for (XY h : home) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) { // 살아남은 피자집의 index번호
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
                }
                sum += dis; // 도시의 피자배달거리
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) { // 0번집부터 6번집으로 뻗어나가기
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }


    static class XY {
        int x;
        int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

