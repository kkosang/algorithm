import java.util.Scanner;

/* [#1] 이진수 출력 (재귀)
 * */
public class No7_02 {
    public static void solution(int n) {
        binary(n);
    }

    public static void binary(int n) {
        if (n == 0) return;
        else {
            binary(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}

