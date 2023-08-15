import java.util.Scanner;

/* [#1] 재귀함수 (스택프레임)
 * */
public class No7_01 {
    public static void solution(int n) {
        recursive(n);
    }

    public static void recursive(int n) {
        if (n == 0) return;
        else {
            System.out.print(n + " "); // 출력하고 호출 -> 호출한 순서 (n, n-1, n-2 ... )
            recursive(n - 1);
            System.out.print(n + " "); // 호출하고 출력 -> 반환 순서 ( 1 , 2, 3 .. n-1 .. n)
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}

