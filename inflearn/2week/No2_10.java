import java.util.Scanner;

/* 봉우리
https://cote.inflearn.com/contest/10/problem/02-10
* */
public class No2_10 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int solution(int n, int arr[][]) {
        int answer = 0;

        for (int i = 0; i < n; i++) { // 행
            for (int j = 0; j < n; j++) { // 열
                boolean flag = true;
                for (int k = 0; k < 4; k++) { // 상하좌우
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) { // 경계처리를 먼저 해줘야함, 앞에서 참조하기 전에
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}

