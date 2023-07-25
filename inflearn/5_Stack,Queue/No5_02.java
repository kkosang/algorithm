import java.util.Scanner;
import java.util.Stack;

/* [#1] 괄호문자제거
https://cote.inflearn.com/contest/10/problem/05-02
* */
public class No5_02 {
    public static String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                while (stack.peek() != '(')
                    stack.pop();
                stack.pop();
            } else {
                stack.push(x);
            }
        }
        while (!stack.isEmpty()){
            answer += stack.pop();
        }
        StringBuilder sb = new StringBuilder(answer).reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        System.out.println(solution(S));
    }
}

