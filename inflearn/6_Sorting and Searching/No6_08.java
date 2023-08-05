import java.util.Arrays;
import java.util.Scanner;

/* [#1] 이분검색
https://cote.inflearn.com/contest/10/problem/06-08
* */
public class No6_08 {
    public static int solution(int n, int target, int arr[]) {
        int idx = -1;
        Arrays.sort(arr);

        int high = n;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) { // 타겟보다 큰 경우
                high = mid - 1;
            } else { // 타겟보다 작은경우
                low = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr) + 1);
    }
}

