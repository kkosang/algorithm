import java.util.Arrays;
import java.util.Scanner;

/* 등수구하기
https://cote.inflearn.com/contest/10/problem/02-08
* */
public class No2_08 {
    public static int[] solution(int n, int num[]) {
        int answer[] = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (num[i] < num[j])
                    cnt++;
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int rank : solution(n, arr))
            System.out.print(rank + " ");
    }
}

