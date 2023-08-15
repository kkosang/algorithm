import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* [#1] 그래프 최단거리 (BFS)
 * */
public class No7_14 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] dis;

    public static void solution(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true; // 방문처리
        dis[v] = 0; // 자기 자신까지의 거리
        queue.add(v); // 큐에 넣기
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nv : graph.get(cur)) { // 현재와 연결된 리스트 가져옴
                if (!visited[nv]) { // 방문하지 않았으면 큐에 넣기
                    visited[nv] = true;
                    queue.add(nv);
                    dis[nv] = dis[cur] + 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        solution(1); // 1번정점에서 출발
        for (int i = 2; i <= n; i++) { // 1번정점에서의 거리 출력
            System.out.println(i + " : " + dis[i]);
        }
    }
}

