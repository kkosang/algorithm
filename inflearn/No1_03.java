import java.util.Scanner;

/* 문장 속 단어
https://cote.inflearn.com/contest/10/problem/01-03
* */
public class No1_03 {
    public static String solution(String str) {
        String answer ="";
        int max = Integer.MIN_VALUE, pos;

        while((pos = str.indexOf(' ')) != -1){ // ' '이 나오는 부분까지
            String tmp = str.substring(0,pos); // 띄어쓰기까지 문자열 분리
            int len = tmp.length(); // 분리된 문자열의 길이
            if(len > max){ // 최대길이보다 길다면
                max = len; // 최댓값 갱신
                answer = tmp; // 정답
            }
            str = str.substring(pos+1); // 문자열을 띄어쓰기 이후 부분으로 이동
        }
        if(str.length() > max) answer = str; // 마지막단어에는 공백이 없기 때문에

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}

/*
 단어를 입력 받는게 아니라 한 줄을 입력 받아야하니까
 => nextLine()
* */