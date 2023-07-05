import java.util.Scanner;

/* 특정 문자 뒤집기
https://cote.inflearn.com/contest/10/problem/01-05
* */
public class No1_05 {
    public static String solution(String str) {
        String answer;
        char [] arr = str.toCharArray();
        int lt = 0, rt = str.length()-1;

        while(lt < rt ){
            if(!('a'<= str.charAt(lt) && str.charAt(lt) <= 'z' ||
            'A' <= str.charAt(lt) && str.charAt(lt) <='Z')){
                lt++;
            }
            else if(!('a'<= str.charAt(rt) && str.charAt(rt) <='z' ||
                    'A' <= str.charAt(rt) && str.charAt(rt) <= 'Z') ){
                rt--;
            }
            else{ // swap
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(arr); // String화시키기, static메소드
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}