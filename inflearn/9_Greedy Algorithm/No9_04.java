import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* [#0] 최대 수입 스케쥴 ( Priority Queue 응용 )
https://cote.inflearn.com/contest/10/problem/09-04
* */
public class No9_04 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Lecture> list = new ArrayList<>();
        int maxD = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            maxD = Math.max(maxD, d);
            list.add(new Lecture(m, d));
        }
        Collections.sort(list);

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0, j = 0;
        for (int i = maxD; i > 0; i--) { // 많이 남은 날짜부터 큐에 넣기
            for (; j < N; j++) {
                if (list.get(j).d < i) break;
                else pQ.add(list.get(j).m); // 현재진행 날짜와 같으면 우선순위 큐에 넣기
            }
            if (!pQ.isEmpty())
                sum = sum + pQ.poll();
        }
        System.out.println(sum);
    }

    static class Lecture implements Comparable<Lecture> {
        int m, d;

        Lecture(int m, int d) {
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture other) {
            if (this.d == other.d) return other.m - this.m;
            else return other.d - this.d;
        }
    }
}

