import java.util.Scanner;

/* 보이는 학생
https://cote.inflearn.com/contest/10/problem/02-02
* */
public class No2_02 {
    public static int solution(int[] student) {
        int answer = 0;
        int curSt = Integer.MIN_VALUE;

        for (int x : student) {
            if (x > curSt) {
                answer++;
                curSt = x;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int student[] = new int[n];
        for (int i = 0; i < n; i++) {
            student[i] = sc.nextInt();
        }
        System.out.println(solution(student));
    }
}