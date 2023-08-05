import java.util.Scanner;

/* [#1] 삽입 정렬
https://cote.inflearn.com/contest/10/problem/06-03
* */
public class No6_03 {
    public static int[] solution(int n, int arr[]) {

        for (int i = 1; i < n; i++) { // 2번째 자료부터
            int key = arr[i];
            int j = i - 1; // i-1번째부터

            while (j >= 0 && key < arr[j]) { // 맨앞까지, 키값이 더 작으면 삽입
                arr[j + 1] = arr[j]; // shift
                j--;
            }

            arr[j + 1] = key;
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

