import java.util.HashMap;
import java.util.Scanner;

/* 아나그램
https://cote.inflearn.com/contest/10/problem/04-02
* */
public class No4_02 {
    public static String solution(String a, String b) {
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : a.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : b.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO"; // map에 없는 문자이거나, map의 value가 이미 0인경우
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
}

