import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* [#1] 동전교환
https://cote.inflearn.com/contest/10/problem/08-05
 * */
public class No8_05 {
    static Integer[] wons;
    static int n, m, min = Integer.MAX_VALUE;

    public static void dfs(int L, int sum) {
        if (L >= min) return; // 최솟값보다 더 깊이 탐색할 필요 없음
        if (sum > m) return; // sum이 15원을 넘은경우
        if (sum == m) { // sum이 만들어 진 경우
            min = Math.min(L, min); // 사용개수중 최솟값
        } else {
            for (int i = 0; i < n; i++) {
                dfs(L + 1, sum + wons[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        wons = new Integer[n];
        for (int i = 0; i < n; i++) {
            wons[i] = sc.nextInt();
        }
        Arrays.sort(wons, Collections.reverseOrder());
        m = sc.nextInt();
        dfs(0, 0);
        System.out.println(min);
    }
}

