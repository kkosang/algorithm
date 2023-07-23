import java.util.Scanner;

/* 부분합
https://www.acmicpc.net/problem/1806
* */

public class No1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 길이 n
        int target = sc.nextInt(); // 기준점 x
        int arr[] = new int[n]; // 수열

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int len = Integer.MAX_VALUE, sum = 0;
        int lt = 0, flag = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];

            while (sum >= target) { // sum이 작아질때까지 반복
                int tmp = rt - lt + 1;
                if (len > tmp) {
                    len = tmp;
                    flag = 1;
                }
                sum -= arr[lt++]; // 빼고 증가
            }
        }
        if (flag == 1) System.out.println(len);
        else System.out.println(0);
    }
}