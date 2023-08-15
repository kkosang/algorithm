import java.util.ArrayList;
import java.util.Scanner;

/* [#1] 경로탐색 (인접리스트,Arraylist)
 * */
public class No7_13 {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void solution(int v) {
        if (v == n) answer++;
        else {
            for (int nextV : graph.get(v)) { // v와 연결된 모든 정점들
                if (!visited[nextV]) {
                    visited[nextV] = true;
                    solution(nextV);
                    visited[nextV] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) { // 0번 1,2,...n번 정점
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) { // 정점 입력받기
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); // a에서 b로 이동가능
        }
        visited[1] = true; // 방문
        solution(1);
        System.out.println(answer);
    }
}

