import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* [#1] 씨름 선수
https://cote.inflearn.com/contest/10/problem/09-01
* */
public class No9_01 {

    static class Person implements Comparable<Person> {
        int cm, kg;

        Person(int cm, int kg) {
            this.cm = cm;
            this.kg = kg;
        }

        @Override
        public int compareTo(Person other) {
            if (this.cm == other.cm) return other.kg - this.kg;
            else return other.cm - this.cm;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Person(a, b));
        }
        Collections.sort(list);

        int max = Integer.MIN_VALUE;
        int answer = 0;
        for (Person x : list) {
            if (max < x.kg) {
                max = x.kg;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

