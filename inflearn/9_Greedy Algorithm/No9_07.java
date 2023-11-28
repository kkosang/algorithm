import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* [#0] 원더랜드 (최소스패닝트리 - 크루스칼)
https://cote.inflearn.com/contest/10/problem/09-07
 * */
public class No9_07 {
    static int[] unf;

    public static int Find(int v) {
        if (v == unf[v]) return v; // 이미 같은 값이면 바로 반환
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb; // 같은 집합으로 만들기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        unf = new int[n + 1];
        ArrayList<Edge> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) unf[i] = i; // 자기 자신은 본인의 집합임 (초기화)
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.add(new Edge(a, b, c));
        }

        // 크루스칼 알고리즘
        Collections.sort(arr);
        int treeEdge = 0;
        int answer = 0;
        for (Edge ob : arr) {
            int fv1 = Find(ob.v1); // v1의 집합 찾기
            int fv2 = Find(ob.v2); // v2의 집합 찾기

            if (fv1 != fv2) {
                answer += ob.cost; // 비용 더하기
                Union(ob.v1, ob.v2); // 같은 집합으로 만들어주기 (싸이클x)
                treeEdge++;
            }

            if (treeEdge == m - 1) break; // 트리가 만들어진 경우
        }

        System.out.println(answer);
    }

    public static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }
}

