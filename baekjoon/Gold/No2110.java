import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* [#2] 공유기 설치
https://www.acmicpc.net/problem/2110
* */
public class No2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집의 개수 N
        int N = Integer.parseInt(st.nextToken());
        // 공유기 개수 C
        int C = Integer.parseInt(st.nextToken());

        int homes[] = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            homes[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(homes);
        // 1 2 4 8 9
        int lt = 1; // ***
        int rt = homes[N-1];

        int distance = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(homes, mid) >= C) { // 설치가능
                distance = mid;
                lt = mid + 1;
            } else { // 설치 불가능
                rt = mid - 1;
            }
        }
        System.out.println(distance);
    }

    public static int count(int homes[], int capacity) {
        int cnt = 1;
        int prev = homes[0];
        for (int x : homes) {
            if (x - prev >= capacity) {
                cnt++;
                prev = x;
            }
        }
        return cnt;
    }
}