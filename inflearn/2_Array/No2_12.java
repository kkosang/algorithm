import java.util.Scanner;

/* 멘토링
https://cote.inflearn.com/contest/10/problem/02-12
수학 등수를 가지고 멘토와 멘티 설정
멘토는 M번의 수학 시험에서 멘티보다 높은등수
멘토와 멘티의 짝을 이룰 수 있는 경우의 수
* */
public class No2_12 {

    public static int solution(int n, int m, int arr[][]) {
        int answer = 0;
        // n 학생 , m 시험 수
        // 행 -> 시험수, 열 -> 학생, 배열값 -> 등수
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {        // ( i, j )학생
                int cnt =0; // 통과한 테스트 수
                for (int k = 1; k <= m; k++) { // 테스트 수
                    int pi = 0, pj = 0;
                    for (int s = 1; s <= n; s++) { // 등 수
                        if (arr[k][s] == i) pi = s;
                        if (arr[k][s] == j) pj = s;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt == m) answer++; // 통과한 수와 총테스트 수가 같으면 멘토멘티
            }
        }
        for (int i = 1; i <= m; i++) { // 시험
            for (int j = 1; j <= n; j++) { // 학생등수

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // m번의 테스트
        int arr[][] = new int[m + 1][n + 1]; // 테스트, 학생
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m, arr));
    }
}

