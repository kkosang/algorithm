import java.util.Scanner;

/* 임시반장 ★ 인덱스 설정
https://cote.inflearn.com/contest/10/problem/02-11
* */
public class No2_11 {

    public static int solution(int n, int arr[][]) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        // i학생과 j학생의 같은학년일때, 같은반이였는지 체크
        for (int i = 1; i <= n; i++) { // i번학생
            int cnt = 0;
            boolean visited[] = new boolean[n + 1];
            for (int j = 1; j <= n; j++) { // j번학생
                for (int k = 1; k <= 5; k++) { // 학급
                    if (!visited[j] && arr[i][k] == arr[j][k]) {
                        cnt++;
                        visited[j] = true;
                    }
                }
            }
            if (max < cnt) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n + 1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}

