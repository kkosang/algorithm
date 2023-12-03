import java.util.*;

/* [#0] 후위표기식
https://www.acmicpc.net/problem/1918
* */

public class Main {

    public static StringBuilder solution(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('+', 2);
        map.put('-', 2);
        map.put('*', 1);
        map.put('/', 1);
        map.put('(', 3);

        for (char x : str.toCharArray()) {
            if (x == '(') { // 여는괄호
                stack.add(x);
            } else if (Character.isAlphabetic(x)) { // 알파벳
                sb.append(x);
            } else if (x == ')') { // 닫기가 나오면
                while (!stack.isEmpty() && stack.peek() != '(') { // 열기까지 다 pop
             
                    sb.append(stack.pop());
                }
           
                stack.pop(); // (괄호 pop
            } else {
                while (!stack.isEmpty() && map.get(stack.peek()) <= map.get(x)) {
      
                    sb.append(stack.pop());
                }

                stack.add(x);
            }
        }
        for (int i = stack.size()-1; i >= 0; i--) {
            sb.append(stack.get(i));
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}

