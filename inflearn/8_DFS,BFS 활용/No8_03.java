import java.util.ArrayList;
import java.util.Scanner;

/* [#1] 최대점수 구하기 (DFS)
https://cote.inflearn.com/contest/10/problem/08-03
 * */
public class No8_03 {

    static int n, limit;

    static class Node {
        int s;
        int t;

        Node(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    static ArrayList<Node> list;
    static int score = Integer.MIN_VALUE;

    public static void solution(int v, int sum,int point) {
        if (sum > limit) return;
        if (v == n) {
            score = Math.max(score,point);
        } else {
            solution(v + 1, sum + list.get(v).t,point+list.get(v).s);
            solution(v + 1, sum,point);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        limit = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list.add(new Node(s, t));
        }
        solution(0, 0,0);
        System.out.println(score);
    }
}

