import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* [#0] 원더랜드 (최소스패닝트리 - 프림)
https://cote.inflearn.com/contest/10/problem/09-07
 * */
public class No9_08 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(); // 인접리스트
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] ch = new boolean[n + 1]; // 체크배열

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }


        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0)); // 시작점 넣기
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int ev = tmp.vex; // 도착지점
            if (!ch[ev]) { // 트리의 원소인지 아닌지 체크
                ch[ev] = true;
                answer += tmp.cost;
                for (Edge ob : graph.get(ev)) { // ev에 연결된 간선들 탐색
                    if (!ch[ob.vex]) pq.add(new Edge(ob.vex, ob.cost));
                }
            }
        }

        System.out.println(answer);
    }

    public static class Edge implements Comparable<Edge> {
        public int vex;
        public int cost;

        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }
}

