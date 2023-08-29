import java.util.Scanner;

/* [#0] 조합 구하기
1부터 N까지 구슬중 M개를 뽑는 방법의 수
레벨과 스타트 번호
 * */
public class No8_09 {

    static int n, m;
    static int[] b;

    public static void dfs(int L, int Start) {
        if (L == m) { // 완성
            for (int x : b) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = Start; i <= n; i++) {
                b[L] = i;
                dfs(L + 1, i + 1); // 다음레벨 , 현재 넣은값 + 1
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        b = new int[m];
        dfs(0, 1);
    }
}

