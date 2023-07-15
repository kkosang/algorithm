import java.util.Scanner;

/* 문자찾기
https://cote.inflearn.com/contest/10/problem/01-01
* */
public class No1_01 {
    public static int solution(String str, char c) {
        int answer=0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        // sol1) for문
        for(int i=0; i<str.length();i++){
            if(str.charAt(i) == c) answer++;
        }

        // sol2) for each문
        for(char x : str.toCharArray()) {
            if(x == c) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        char c = sc.next().charAt(0); // sc.next()-> string .charAt -> char
        System.out.println(solution(target,c));
    }
}

/*
* 대소문자 구분하지 않음 -> toUpperCase() 대문자로 만들기
* for each문 -> 배열, iterator 리스트..
* toCharArray() -> String의 문자 하나씩을 문자배열로 형성함
* */