import java.util.ArrayList;
import java.util.Scanner;

/* 가위 바위 보
https://cote.inflearn.com/contest/10/problem/02-03
* */
public class No2_03 {
    public static String solution(int n, int[] a, int[] b) {
        String answer = "";
        // A와 B가 비기는경우, A가 가위로 이기는 경우, A가 바위로 이기는경우, A가 보로 이기는 경우 , else -> 비가 이기는경우
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) { // 가위
                if (b[i] == 1) {
                    answer += 'D';
                } else if (b[i] == 2) {
                    answer += 'B';
                } else {
                    answer += 'A';
                }
            } else if (a[i] == 2) { // 바위
                if (b[i] == 1) {
                    answer += 'A';
                } else if (b[i] == 2) {
                    answer += 'D';
                } else {
                    answer += 'B';
                }
            } else { // 보
                if (b[i] == 1) {
                    answer += 'B';
                } else if (b[i] == 2) {
                    answer += 'A';
                } else {
                    answer += 'D';
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        for (char c : solution(n, a, b).toCharArray()) {
            System.out.println(c);
        }
    }
}