import java.util.Scanner;

/* 가장 짧은 문자거리 ★
https://cote.inflearn.com/contest/10/problem/01-10
* */
public class No1_10 {
    public static int[] solution(String str, char t) {
        int answer[] = new int[str.length()];
        // 왼쪽으로부터의 거리
        int p = 100;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i) == t){
                p = 0;
                answer[i] = p;
            }
            else{
                p ++;
                answer[i] = p;
            }
        }

        // 오른쪽으로부터의 거리
        p = 100;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i) == t) p = 0;
            else{
                p++;
                answer[i] = Math.min(answer[i],p);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char t = sc.next().charAt(0);
        for(int x : solution(str,t)){
            System.out.print(x + " ");
        }
    }
}