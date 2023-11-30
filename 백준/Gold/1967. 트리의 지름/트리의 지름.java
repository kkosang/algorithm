import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int n, answer, farNode;
    public static ArrayList<ArrayList<Edge>> tree = new ArrayList<>();
    public static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 무방향(트리)
            tree.get(a).add(new Edge(b, c));
            tree.get(b).add(new Edge(a, c));
        }

        visited = new boolean[n + 1];
        dfs(1, 0); // 가장 먼 노드 찾기

        visited = new boolean[n + 1];
        dfs(farNode, 0); // 가장 멀리 있는 노드까지 탐색

        System.out.println(answer);
    }

    public static void dfs(int node, int dis) {
        visited[node] = true;

        if (dis > answer) { // 멀리 떨어진 노드 갱신
            answer = dis;
            farNode = node;
        }

        // 이웃한 노드 탐색
        for (Edge neighbor : tree.get(node)) {
            if (!visited[neighbor.to]) { // 방문하지 않은 곳이면
                dfs(neighbor.to, dis + neighbor.cost);
            }
        }
    }

    public static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

    }
}
