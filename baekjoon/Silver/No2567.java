import java.util.Scanner;

/*  https://www.acmicpc.net/problem/2567
 * 둘레를 1이 접하고 있는 0의 개수 -> 도화지의 끝면에 붙여있는 경우 고려하지 못함
 * sol 1) 도화지 끝에 달라붙은 경우 경곗값 처리
 * sol 2) 도화지 밖을 0으로 채움
 * */
public class No2567 {

    public static void main(String[] args) {
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 색종이 수
        boolean visited[][] = new boolean[100][100];

        int total = 0;
        for (int i = 0; i < n; i++) {
            int px = sc.nextInt(); // x좌표
            int py = sc.nextInt(); // y좌표
            for (int x = px; x < px + 10; x++) {
                for (int y = py; y < py + 10; y++) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                    }
                }
            }
        }

        for (int i = 0; i < 100; i++) { // x
            for (int j = 0; j < 100; j++) { // y
                if (visited[i][j]) { // 색종이이면
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && !visited[nx][ny]) { // 범위내에 있고, 주변이 0인경우
                            total++;
                        } else if (0 > nx || 0 > ny || 100 <= nx || 100 <= ny) { // 도화지에 붙어있는 경우
                            total++;
                        }
                    }
                }
            }
        }
        System.out.println(total);
    }
}

