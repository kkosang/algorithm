import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* [#0] 장난꾸러기
https://cote.inflearn.com/contest/10/problem/06-06
* */
public class No6_06 {
    public static ArrayList<Integer> solution(int n, int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int copy[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        for (int i = 1; i <= n; i++) {
            if (arr[i] != copy[i]) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int  x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}

