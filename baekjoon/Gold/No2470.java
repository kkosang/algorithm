import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/* [#0] 두 용액
https://www.acmicpc.net/problem/2470
* */
public class No2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 용액 개수 N
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // -99 -2 -1 4 98

        int rt = N - 1;
        int lt = 0;
        int idx1 = 0, idx2 = N - 1;
        int max = Integer.MAX_VALUE;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            int temp = Math.abs(sum);
            if (max > temp) {
                max = temp;
                idx1 = lt;
                idx2 = rt;
            }
            if (sum < 0) { // 음수
                lt++;
            } else if (sum > 0) { // 양수
                rt--;
            }else{
                break;
            }
        }
        System.out.println(arr[idx1] + " " + arr[idx2]);
    }
}
