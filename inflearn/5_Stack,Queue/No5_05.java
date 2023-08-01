import java.util.Scanner;
import java.util.Stack;

/* [#1] 쇠막대기
https://cote.inflearn.com/contest/10/problem/05-05
* */
public class No5_05 {
    public static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char prev = ' ';
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else { // 닫기 괄호
                stack.pop();
                if (prev == '(') { // 이전괄호가 ( 였으면 -> 레이저
                    answer += stack.size();
                }
                else{
                    answer+=1;
                }
            }
            prev = x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}

