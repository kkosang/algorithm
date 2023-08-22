import java.util.Scanner;

/* [#1] 바둑이 승차 (DFS)
https://cote.inflearn.com/contest/10/problem/08-02
 * */
public class No8_02 {
    static int kg, n, answer;
    static int[] dogs, check;


    public static void solution(int v) {
        int sum = 0;
        if (v == n) {
            for (int i = 0; i < n; i++) {
                if (check[i] == 1) {
                    sum += dogs[i];
                }
                if (sum > kg) return;
                else answer = Math.max(answer, sum);
            }
        } else {
            check[v] = 1;
            solution(v + 1);
            check[v] = 0;
            solution(v + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        kg = sc.nextInt();
        n = sc.nextInt();
        dogs = new int[n];
        for (int i = 0; i < n; i++) {
            dogs[i] = sc.nextInt();
        }
        check = new int[n];
        solution(0);
        System.out.println(answer);
    }
}

