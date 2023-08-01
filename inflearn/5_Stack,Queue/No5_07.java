import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* [#1] 교육과정 설계 -> 큐 이용안했음
https://cote.inflearn.com/contest/10/problem/05-07
* */
public class No5_07 {
    public static String solution(String a, String b) {
        String answer = "NO";

        int i = 0;
        for (char x : b.toCharArray()) {
            if (i < a.length() && a.charAt(i) == x) i++;
        }
        if (i == a.length()) answer = "YES";

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
}

