import java.util.Scanner;

/* [#1] 팩토리얼
 * */
public class No7_03 {
    public static void solution(int n) {
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}

