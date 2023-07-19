import java.util.Scanner;

/* 연속된 자연수의 합
https://cote.inflearn.com/contest/10/problem/03-05
* */
public class No3_05 {
    public static int solution(int n) {
        int answer = 0, lt = 1;
        int sum = 0;
        for (int rt = 1; rt <= n / 2 + 1; rt++) {
            sum += rt;
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= lt;
                lt++;
                if (sum == n) answer++;
            }
        }
        return answer;
    }

    public static int solution2(int n) {
        int answer = 0;
        int cnt = 1; // 연속된 자연수의 개수
        n--; // n에서 1빼기
        while (n > 0) {
            cnt++; // 연속된 수 하나 증가
            n = n - cnt;
            int plus = n / cnt;
            if (n % cnt == 0) {
                for (int i = 1; i <= cnt; i++) { // 연속된 자연수의 개수만큼
                    System.out.print(i + plus + "+");
                }
                System.out.println(" ");
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution2(n));
    }
}