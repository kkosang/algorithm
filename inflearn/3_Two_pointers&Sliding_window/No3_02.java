import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 공통원소 구하기
https://cote.inflearn.com/contest/10/problem/03-02
* */
public class No3_02 {
    public static ArrayList<Integer> solution(int n, int m, int a[], int b[]) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                answer.add(a[i]);
                i++;
                j++;
            }
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

