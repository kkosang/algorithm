import java.util.Scanner;
import java.util.Stack;

/* [#1] 크게 만들기 // param사용시 -> 새로운 변수로 할당 !!!!!!!!!!!!!!!
https://www.acmicpc.net/problem/2812
* */
public class No5_study3 {
    public static String solution(int n, int k, String num) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int cnt = k;
        for (char x : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < x && k > 0) {
                k--;
                stack.pop();
            }
            stack.add(x);
        }
        int loop = n - cnt;
        for (char x : stack) {
            if (loop == 0) break;
            sb.append(x);
            loop--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String num = sc.next();
        System.out.println(solution(n, k, num));
    }
}

