import java.util.ArrayList;
import java.util.Scanner;

/* 소수의 연속합
https://www.acmicpc.net/problem/1644
* */

public class No1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 자연수n
        int arr[] = new int[n + 1];
        ArrayList<Integer> prime = new ArrayList<>();
        // 에라토스테네스 체
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i] == 0) {
                for (int j = i; j <= n; j = j + i) {
                    if (i != j) arr[j] = 1;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) prime.add(i);
        }

        int lt = 0, sum = 0, answer = 0;
        for (int rt = 0; rt < prime.size(); rt++) {
            sum += prime.get(rt);
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= prime.get(lt);
                lt++;
                if (sum == n) answer++;
            }
        }
        System.out.println(answer);

    }
}