import java.util.Scanner;

/* 최대 매출
https://cote.inflearn.com/contest/10/problem/03-03
* */
public class No3_03 {
    public static int solution(int n, int k, int a[]) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        int max = sum;

        for (int i = k; i < n; i++) {
            sum = sum + a[i] - a[i - k]; // 값 추가, 이전 값 삭제
            if (max < sum) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(solution(n, k, A));
    }
}

    /*public static int solution(int n, int k, int a[]) {
        int answer=0;
        int prefixSum[] = new int[n];

        prefixSum[0] = a[0];
        prefixSum[1] = prefixSum[0] + a[1];
        for (int i = 2; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + a[i];
        }

        int max = 0;
        for (int i = 0; i < n-k; i++) {
            int sum = prefixSum[i+k] - prefixSum[i];
            if(sum > max) max = sum;
        }
        System.out.println(max);
        return answer;
    }*/
