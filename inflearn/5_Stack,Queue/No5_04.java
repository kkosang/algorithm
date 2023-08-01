import java.util.Scanner;
import java.util.Stack;

/* [#1] 후위식 연산(postfix) -> 연산자를 만나면 pop 2번 -> 계산결과 스택에 넣기
https://cote.inflearn.com/contest/10/problem/05-04
* */
public class No5_04 {
    public static int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x >= '0' && x <= '9') {
                stack.push(x - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int c = 0;
                switch (x) {
                    case '+':
                        c = a + b;
                        break;
                    case '-':
                        c = a - b;
                        break;
                    case '*':
                        c = a * b;
                        break;
                    case '/':
                        c = a / b;
                        break;
                }
                stack.push(c);
            }
        }
        answer = stack.pop();
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}

