import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/* [#1] 공주구하기
https://cote.inflearn.com/contest/10/problem/05-06
* */
public class No5_06 {
    public static int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int cnt = 1;
        while (!q.isEmpty()) {
            if (cnt == k) {
                answer = q.poll();
                cnt = 1;
            } else {
                q.add(q.poll());
                cnt++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }
}

