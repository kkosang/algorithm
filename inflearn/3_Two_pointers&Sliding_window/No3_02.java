import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* [#2] 공통원소 구하기
https://cote.inflearn.com/contest/10/problem/03-02
* */
public class No3_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int b[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> answer = intersectionArray(n, a, m, b);
        printAnswer(answer);
    }

    private static ArrayList<Integer> intersectionArray(int n, int[] a, int m, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) { // 공통원소
            if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else { // 같은경우
                answer.add(a[i]);
                i++;
                j++;
            }
        }
        return answer;
    }

    private static void printAnswer(ArrayList<Integer> answer) {
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}

