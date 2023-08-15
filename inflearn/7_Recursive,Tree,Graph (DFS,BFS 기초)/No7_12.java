import java.util.Scanner;

/* [#1] 경로탐색 (DFS)
 * */
public class No7_12 {
    static int n, m, answer = 0;
    static int[][] graph;
    static boolean[] visited;

    public static void solution(int v) {
        if (v == n) { // 도착지점에 도달하면
            answer++;
        } else { // 도착지점이 아닌 경우
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && !visited[i]) { // v에서 i정점으로 이동할 수 있고, 방문하지 않았다면 탐색
                    visited[i] = true; // 방문처리후
                    solution(i); // DFS
                    visited[i] = false; // 백트래킹
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) { // 정점 입력받기
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        visited[1] = true; // 방문
        solution(1);
        System.out.println(answer);
    }
}

