import java.util.Scanner;
import java.util.Stack;

/* [#2] 괄호문자제거
https://cote.inflearn.com/contest/10/problem/05-02
* */
public class No5_02 {
    public static String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(') ;
            } else {
                stack.push(x); // 여는괄호거나 알파벳
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        System.out.println(solution(S));
    }
}

