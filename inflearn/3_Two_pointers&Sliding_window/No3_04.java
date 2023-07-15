import java.util.Scanner;

/* 연속 부분수열
https://cote.inflearn.com/contest/10/problem/03-04
* */
public class No3_04 {
    public static int solution(int n, int target, int a[]) {
        int answer = 0, sum = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += a[rt];
            if (sum == target) answer++;
            while (sum >= target) { // sum이 작아질때까지 반복
                sum -= a[lt++]; // 빼고 증가
                if (sum == target) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(solution(n, target, A));
    }
}