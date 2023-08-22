import java.util.Scanner;

/* [#1] 중복순열 구하기
 * */
public class No8_04 {
    static int[] pm;
    static int n, m;

    public static void solution(int L) {
        if (L == m) {
            // 출력
            for (int x : pm) System.out.print(x+" ");
            System.out.println("");

        } else {
            // 이진트리가 아니라 n번 호출
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                solution(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m]; // n개중 m개 뽑기
        solution(0);
    }
}

