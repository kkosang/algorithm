import java.util.Scanner;

/* 중복문자제거
https://cote.inflearn.com/contest/10/problem/01-06
* */
public class No1_06 {
    public static String solution(String str) {
        String answer="";
        for(int i=0;i<str.length();i++){
            //System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}