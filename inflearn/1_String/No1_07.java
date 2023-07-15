import java.util.Scanner;

/* 회문 문자열
https://cote.inflearn.com/contest/10/problem/01-07
* */
public class No1_07 {
    public static String solution(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString(); // SB를 역순 문자열로 변경
        if(str.equalsIgnoreCase(tmp)) answer= "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}