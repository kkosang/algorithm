import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* [#1] 합이 같은 부분집합 ( DFS : 아마존 인터뷰 )
https://cote.inflearn.com/contest/10/problem/08-01
 * */
public class No8_01 {
    static int n;
    static boolean[] used;
    static int[] set;
    static String answer = "NO";

    public static void solution(int v) {
        int sum1 = 0, sum2 = 0;
        if (v == n) { // 리프노드
            for (int i = 0; i < n; i++) {
                if (used[i]) sum1 += set[i];
                else sum2 += set[i];
            }
            if (sum1 == sum2) answer = "YES";
        } else {
            used[v] = true; // 사용
            solution(v + 1);
            used[v] = false; // 사용x
            solution(v + 1);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 원소의 개수
        set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = sc.nextInt();
        }
        used = new boolean[n];
        solution(0);
        System.out.println(answer);
    }
}

