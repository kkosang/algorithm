import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 문제의 수
        int m = Integer.parseInt(st.nextToken()); // 문제에 대한 정보의 수

        // 그래프 선언 및 초기화 (n+1)개
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 진입차수 선언 및 초기화
        int edgeCount[] = new int[n + 1];

        // 정보의 수 만큼 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b); // a번 문제는 b보다 먼저
            edgeCount[b]++; // b의 진입차수 증가
        }

        // 우선순위 큐 선언 및 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 진입차수가 0인것 큐에 집어넣기
        for (int i = 1; i <= n; i++) {
            if (edgeCount[i] == 0)
                pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        // 큐 탐색
        while (!pq.isEmpty()) {
            int cur = pq.poll(); // 현재 문제빼기

            sb.append(cur + " ");

            List<Integer> list = graph.get(cur); // 현재와 관련있는 정보 받아오기

            // 리스트의 사이즈만큼 탐색
            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i); // 관련문제 가져옴
                edgeCount[temp]--; // 진입차수 줄이기

                // 진입차수가 0이면 큐에 넣음
                if (edgeCount[temp] == 0)
                    pq.add(temp);
            }
        }

        System.out.println(sb);
    }
}
