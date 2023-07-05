import java.util.Scanner;

/* 암호
https://cote.inflearn.com/contest/10/problem/01-12
* */
public class No1_12 {
    public static String solution(String s) {
        String answer ="";
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                cnt++;
            }
            else{
                sb.append(s.charAt(i));
                if(cnt>1)
                    sb.append(cnt);
                cnt = 1;
            }
        }
        // 마지막에 압축 시키지 않은 문자열
        sb.append(s.charAt(s.length()-1));
        if(cnt>1)
            sb.append(cnt);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}