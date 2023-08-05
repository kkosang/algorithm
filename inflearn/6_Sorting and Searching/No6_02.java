import java.util.Scanner;

/* [#1] 버블 정렬
https://cote.inflearn.com/contest/10/problem/06-02
* */
public class No6_02 {
    public static int[] solution(int n, int arr[]) {

        for (int i = 0; i < n - 1; i++) { // 반복횟수
            for (int j = 0; j < n - i - 1; j++) { // 인덱스
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
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

