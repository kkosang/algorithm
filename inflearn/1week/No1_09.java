import java.util.Scanner;

/* 숫자만 추출
https://cote.inflearn.com/contest/10/problem/01-09
* */
public class No1_09 {
    public static int solution(String str) {
        int answer;
        str = str.replaceAll("[^0-9]","");
        answer = Integer.parseInt(str);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}