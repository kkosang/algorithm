import java.util.ArrayList;
import java.util.Scanner;

/* 큰 수 출력하기
https://cote.inflearn.com/contest/10/problem/02-01
* */
public class No2_01 {
    public static ArrayList<Integer> solution(int[] bigNumber) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < bigNumber.length; i++) {
            if (i == 0)
                answer.add(bigNumber[i]);
            else {
                if(bigNumber[i] > bigNumber[i-1])
                    answer.add(bigNumber[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bigNumber[] = new int[n];
        for (int i = 0; i < n; i++) {
            bigNumber[i] = sc.nextInt();
        }
       for(int x : solution(bigNumber)){
           System.out.print(x + " ");
       }
    }
}