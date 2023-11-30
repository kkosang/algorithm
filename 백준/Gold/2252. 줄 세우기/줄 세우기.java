import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
참고자료
https://codingnojam.tistory.com/67
* */
public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생번호
        int m = Integer.parseInt(st.nextToken()); // 비교횟수

        // 그래프 초기화 (n+1)개
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int edgeCount[] = new int[n + 1]; // 진입차수 저장배열

        // 비교횟수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 두명의 학생
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add((b));
            edgeCount[b]++; // 늦게 줄 서야함
        }

        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (edgeCount[i] == 0) { // 가장 빨리 줄 서야하는 애
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll(); // 학생꺼내기

            sb.append(cur + " "); // 현재번호 출력값에 저장

            List<Integer> list = graph.get(cur); // 비교정보 가져오기

            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);
                edgeCount[temp]--; // 진입차수 감소

                if (edgeCount[temp] == 0) {
                    q.add(temp);
                }
            }
        }

        System.out.println(sb);
    }
}
