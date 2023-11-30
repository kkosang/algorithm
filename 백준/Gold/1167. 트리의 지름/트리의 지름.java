import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
* https://moonsbeen.tistory.com/101*/
public class Main {
    static int vertex;
    public static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    static int maxCost = 0;
    static int farNode;
    public static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        vertex = Integer.parseInt(br.readLine());

        for (int i = 0; i <= vertex; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < vertex; i++) { // 정점의 개수만큼 입력받음
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;

                int c = Integer.parseInt(st.nextToken());
                tree.get(a).add(new Node(b, c));
            }

        }

        // 가장 먼 노드 찾기
        visited = new boolean[vertex + 1];
        dfs(1, 0);

        // 가장 먼 노드에서, 반대편 가장 먼 노드까지의 거리 구하기
        visited = new boolean[vertex + 1];
        dfs(farNode, 0);

        System.out.println(maxCost);
    }

    public static void dfs(int from, int dis) {
        visited[from] = true;

        if (dis > maxCost) { // 가장 먼 노드 저장
            maxCost = dis;
            farNode = from;
        }
        for (Node neighbor : tree.get(from)) {
            if (!visited[neighbor.to]) {
                dfs(neighbor.to, dis + neighbor.cost);
            }
        }
    }

    public static class Node {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}