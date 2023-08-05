import java.util.ArrayList;
import java.util.Scanner;

/* [#1] 선택 정렬
https://cote.inflearn.com/contest/10/problem/06-01
* */
public class No6_01 {
    public static int[] solution(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }

        return arr;
    }

    static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int sort : solution(n, arr)) System.out.print(sort + " ");
    }
}

