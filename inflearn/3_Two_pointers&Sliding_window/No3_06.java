import java.util.Scanner;

/* 최대 길이 연속부분수열
https://cote.inflearn.com/contest/10/problem/03-06
* */
public class No3_06 {
    public static int solution(int n, int k, int a[]) {
        int answer = 0, lt = 0;
        int len = 0, cntk = 0;


        for (int rt = 0; rt < n; rt++) {
            if (a[rt] == 0) cntk++; // 0개수 세기

            while (cntk > k) {
                if (a[lt] == 0) cntk--;
                lt++;
            }
            len = rt - lt + 1;
            answer = Math.max(len, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(solution(n, k, a));
    }
}