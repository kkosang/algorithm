import java.util.Scanner;

/* 소수 (에라토스테네스 체)
https://cote.inflearn.com/contest/10/problem/02-05
* */
public class No2_05 {
    public static int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) { // 2~n까지의 수
            if (isPrimeNumber(i)) {
                answer++;
            }
        }
        return answer;
    }
    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}

