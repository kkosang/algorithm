import java.util.Arrays;
import java.util.Scanner;

/* [#0] 뮤직비디오(결정알고리즘)
https://cote.inflearn.com/contest/10/problem/06-09
* */
public class No6_09 {
    public static int solution(int n, int m, int arr[]) {
        int answer = -1;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        return answer;
    }

    static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) { // 수용범위보다 큰경우 카운팅
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}

