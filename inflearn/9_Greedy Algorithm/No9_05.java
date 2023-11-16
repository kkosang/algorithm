import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* [#0] 다익스트라 알고리즘 -> O(n * log n)
 * */
public class No9_05 {

    static int n, m; // 정점의 수 & 간선의 수
    static ArrayList<ArrayList<Edge>> graph; // 인접리스트(정점과 비용)
    static int[] dis; // 거리배열

    static class Edge implements Comparable<Edge> {
        public int vex; // 정점
        public int cost; // 비용

        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        public int compareTo(Edge other) {
            return this.cost - other.cost; // 비용으로 내림차순정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) { // 0부터 n까지의 graph생성 (정점)
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE); // 최댓값으로 전부 초기화

        for (int i = 0; i < m; i++) { // 간선의 수 만큼 입력받기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c)); // a정점에 연결된 b정점,비용
        }

        Dijkstra(1);
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }

    public static void Dijkstra(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>(); // log n
        pQ.offer(new Edge(v, 0)); // 자기 자신으로 가는 비용 0
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int cur = tmp.vex;
            int curCost = tmp.cost;
            if (curCost > dis[cur]) continue;
            for (Edge ob : graph.get(cur)) { // cur과연결된 Edge
                if (dis[ob.vex] > curCost + ob.cost) {
                    dis[ob.vex] = curCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, curCost + ob.cost));
                }
            }
        }
    }
}

