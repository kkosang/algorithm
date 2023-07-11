import java.util.ArrayList;
import java.util.Scanner;

/* 뒤집은 소수
https://cote.inflearn.com/contest/10/problem/02-06
* */
public class No2_06 {
    public static ArrayList<Integer> solution(int n, int num[]) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int x : num) {
            int reverse = 0;
            while (x > 0) {
                int a = x % 10;
                reverse = reverse * 10 + a;
                x = x / 10;
            }
            if (isPrimeNumber(reverse)) {
                answer.add(reverse);
            }
        }
        return answer;
    }

    public static boolean isPrimeNumber(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}

