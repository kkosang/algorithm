import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/* [#0] K번째 큰 수 -> n장의 카드중에서 3장의 카드 뽑기
https://cote.inflearn.com/contest/10/problem/04-05
* */
public class No4_05 {
    public static int solution(int arr[], int n, int k) {
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int p = 0; p < n; p++) {
            for (int q = p + 1; q < n; q++) {
                for (int r = q + 1; r < n; r++) {
                    Tset.add(arr[p] + arr[q] + arr[r]);
                }
            }
        }
        int cnt = 0;
        for (int x : Tset) {
            cnt++;
            if (cnt == k) return x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr, n, k));
    }
}

