import java.util.Scanner;

/* 피보나치 수열
https://cote.inflearn.com/contest/10/problem/02-04
* */
public class No2_04 {
    public static int[] solution(int n) {
        int answer[] = new int[n];
        answer[0] = answer[1] = 1;
        for (int i = 2; i < n; i++)
            answer[i] = answer[i - 2] + answer[i - 1];

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int x : solution(n)) {
            System.out.print(x + " ");
        }
    }
}