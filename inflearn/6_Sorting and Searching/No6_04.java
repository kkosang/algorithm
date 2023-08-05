import java.util.Scanner;

/* [#0] LRU 카카오변형
https://cote.inflearn.com/contest/10/problem/06-04
* */
public class No6_04 {
    public static int[] solution(int s, int n, int arr[]) {
        int cache[] = new int[s];

        for (int temp : arr) {
            int pos = -1; // 작업위치
            for (int i = 0; i < s; i++) { // hit
                if (cache[i] == temp) pos = i;
            }
            if (pos == -1) { // miss
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = temp;
        }

        return cache;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); // 캐시의 크기
        int n = sc.nextInt(); // 작업개수
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int p : solution(size, n, arr)) {
            System.out.print(p + " ");
        }
    }
}

