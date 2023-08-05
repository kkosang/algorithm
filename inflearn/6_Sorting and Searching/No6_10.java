import java.util.Arrays;
import java.util.Scanner;

/* [#1] 마구간 정하기(결정알고리즘)
이분탐색 하기 위해서는 정렬 !!
https://cote.inflearn.com/contest/10/problem/06-10
* */
public class No6_10 {
    public static int solution(int n, int m, int arr[]) {
        int answer = 0;

        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= m) { // 더 크게 만들 수 있음
                answer = mid;
                lt = mid + 1;
            } else { // 못만드니까 줄이기
                rt = mid - 1;
            }
        }
        return answer;
    }

    static int count(int[] arr, int capacity) {
        int cnt = 1;
        int prev = arr[0];
        for (int x : arr) {
            if (x - prev >= capacity) { // 수용범위보다 큰경우 카운팅
                cnt++;
                prev = x;
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

