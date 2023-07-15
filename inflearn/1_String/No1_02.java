import java.util.Scanner;

/* 대소문자 변환
https://cote.inflearn.com/contest/10/problem/01-02
* */
public class No1_02 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.isLowerCase(c)){ // 소문자 true
                sb.append(Character.toUpperCase(c)); // 대문자로 변환함
            }
            else{
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        System.out.println(solution(target));
    }
}

/*
소문자인지 대문자인지 판단 -> Character.isLowerCase(x) @1 char타입
* */