import java.util.Scanner;

/* 유효한 팰린드롬(replaceAll정규식)
https://cote.inflearn.com/contest/10/problem/01-08
* */
public class No1_08 {
    public static String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]",""); //대문자 A-Z까지가 아니면 replace
        String tmp = new StringBuilder(str).reverse().toString(); // SB를 역순 문자열로 변경
        if(str.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}