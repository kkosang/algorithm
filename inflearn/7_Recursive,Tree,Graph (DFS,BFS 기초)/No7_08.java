import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* [#1] 송아지 찾기 1 (BFS : 상태트리탐색)
https://cote.inflearn.com/contest/10/problem/07-08
 * */
public class No7_08 {
    static int answer = 0;
    static int[] dis = {1, -1, 5};
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static int solution(int s, int e) {
        visited = new boolean[10001];
        visited[s] = true;
        q.add(s);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx == e) return L + 1;
                    if (nx >= 1 && nx <= 10000 && !visited[nx]) {
                        visited[nx] = true;
                        q.add(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(solution(s, e));
    }
}

