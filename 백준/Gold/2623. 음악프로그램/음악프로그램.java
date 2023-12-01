import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int indegree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) { // 그래프 초기화
            graph.add(new ArrayList<>());
        }
        indegree = new int[n + 1]; // 차수 초기화

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int token = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            for (int j = 1; j < token; j++) {
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                indegree[b]++;

                a = b;
            }
        }

        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {// 진입차수가 0인것 큐에 넣기
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            answer.add(cur);

            for (int next : graph.get(cur)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        // 사이클이 생긴경우
        if (answer.size() != n) {
            System.out.println(0);
        } else {
            for (int order : answer) {
                System.out.println(order);
            }
        }
    }
}