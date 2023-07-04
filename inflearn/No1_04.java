import java.util.Scanner;

/* 단어 뒤집기
https://cote.inflearn.com/contest/10/problem/01-04
* */
public class No1_04 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String str = sc.next();
            str = solution(str);
            System.out.println(str);
        }
    }
}

/*

* */