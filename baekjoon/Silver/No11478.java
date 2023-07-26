import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/* [#1] 서로 다른 부분 문자열의 개수
https://www.acmicpc.net/problem/11478
* */
public class No5_study {
    public static int solution(String a) {
        int answer = 0;

        TreeSet<String> tset = new TreeSet<>();
        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j <= a.length(); j++) {
                tset.add(a.substring(i, j));
            }
        }
        answer = tset.size();
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}

