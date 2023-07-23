import java.util.Scanner;

/* 블로그
https://www.acmicpc.net/problem/21921
* */
public class No21921 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n일동안
        int x = sc.nextInt(); // 기간
        int visited[] = new int[n + 1]; // 일별 방문자수
        int prefix[] = new int[n + 1]; // 누적 방문자수
        for (int i = 1; i <= n; i++) {
            visited[i] = sc.nextInt();
        }

        prefix[0] = 0;
        for (int i = 1; i <= n; i++) { // 인덱스 1부터 사용
            prefix[i] = prefix[i - 1] + visited[i];
        }

        int maxV = -1, v = 0;
        int cnt = 1;
        for (int rt = 0; rt <= n - x; rt++) {
            v = prefix[rt + x] - prefix[rt];
            if (v == maxV) cnt++;
            if (v > maxV) {
                cnt = 1; // 큰 값이 나오면 기간 초기화
                maxV = v;
            }
        }

        if (maxV == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxV);
            System.out.println(cnt);
        }
    }
}