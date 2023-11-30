import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int vertex, edge;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken()); // 정점의 수
        edge = Integer.parseInt(st.nextToken()); // 간선의 수

        parent = new int[vertex + 1];
        for (int i = 1; i <= vertex; i++) {
            parent[i] = i; // 초기값을 자기 자신으로 설정
        }

        List<Edge> edges = new ArrayList<>();


        // 간선의 수 만큼 입력
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, cost));
        }

        // 크루스칼
        Collections.sort(edges);
        int answer = 0;

        // 트리생성
        for (Edge edge : edges) {
            // 사이클이 발생하지 않는 경우만 -> 다른집합
            if (find(edge.a) != find(edge.b)) {
                union(edge.a, edge.b);
                answer += edge.cost;
            }
        }

        System.out.println(answer);
    }

    public static class Edge implements Comparable<Edge> {
        int a, b;
        int cost;

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Edge edge) {
            return Integer.compare(this.cost, edge.cost);
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }
}
