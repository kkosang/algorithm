import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

/* [#1] 문자열 폭발 -> 메모리초과
https://www.acmicpc.net/problem/9935
* */
public class No5_study2 {
    public static String solution(String str, String f) {
        StringBuilder sb = new StringBuilder();
        int fLen = f.length();

        for (char ch : str.toCharArray()) {
            sb.append(ch);
            int ansLen = sb.length();
            if (ansLen >= fLen && sb.substring(ansLen - fLen).equals(f))
                sb.delete(ansLen - fLen, ansLen);
        }
        return (sb.length() == 0) ? "FRULA" : sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String fire = sc.next();
        System.out.println(solution(str, fire));
    }
}

