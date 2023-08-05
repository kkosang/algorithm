import java.util.*;

/* [#0] 좌표정렬(compareTo)
https://cote.inflearn.com/contest/10/problem/06-07
* */
public class No6_07 {
    static class Dots implements Comparable<Dots> {
        int x, y;

        Dots(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Dots other) {
            if (this.x == other.x) return this.y - other.y; // x가 같으면 y로 정렬
            else return this.x - other.x; // 다른경우, x로 비교하여 정렬
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Dots> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Dots(x, y));
        }
        Collections.sort(list);
        for (Dots p : list) {
            System.out.println(p.x + " " + p.y);
        }

    }
}

