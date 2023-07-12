import java.util.ArrayList;
import java.util.Scanner;

/* 점수계산
https://cote.inflearn.com/contest/10/problem/02-07
* */
public class No2_07 {
    public static int solution(int n, int num[]) {
        int answer = 0;

        int point = 0;
        for (int x : num) {
            if (x == 1) {
                point++;
                answer += point;
            } else {
                point = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(n, arr));
    }
}

