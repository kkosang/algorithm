import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/* [#0] 응급실 -> 우선순위 큐로 풀려다가 실패
https://cote.inflearn.com/contest/10/problem/05-08
* */

public class No5_08 {
    static class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static int solution(int n, int m, int arr[]) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(new Person(i, arr[i])); // id와 우선순위값
        }

        while (!q.isEmpty()) {
            Person tmp = q.poll();
            for (Person x : q) { // 큐에서 person객체
                if (x.priority > tmp.priority) {
                    q.add(tmp); // 다시 넣어주기
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}

