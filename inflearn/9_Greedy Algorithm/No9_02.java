import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* [#1] 회의실 배정
https://cote.inflearn.com/contest/10/problem/09-02
* */
public class No9_02 {
    static class Time implements Comparable<Time> {
        int s, e;

        Time(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Time other) {
            if (this.e == other.e) return this.s - other.s;
            else return this.e - other.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Time> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Time(s, e));
        }

        Collections.sort(list);

        int cnt = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (list.get(i).s >= end) {
                cnt++;
                end = list.get(i).e;
            }
        }
        System.out.println(cnt);
    }
}

