import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/* [#1] 올바른 괄호
https://cote.inflearn.com/contest/10/problem/05-01
* */
public class No5_01 {
    public static String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else { // ')'
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) answer = "NO";

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        System.out.println(solution(S));
    }
}

