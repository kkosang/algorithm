import java.util.Scanner;

/* 두 배열 합치기
https://cote.inflearn.com/contest/10/problem/03-01
* */
public class No3_01 {
    public static int[] solution(int n, int m, int a[], int b[]) {
        int answer[] = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) { // 공통부분
            if (a[i] > b[j])
                answer[k++] = b[j++];
            else
                answer[k++] = a[i++];
        }

        // 남은부분
        while (i < n) {
            answer[k++] = a[i++];
        }
        while (j < m) {
            answer[k++] = b[j++];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int B[] = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        for (int i : solution(n, m, A, B)) {
            System.out.print(i + " ");
        }
    }
}

