import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Person(x,y));
        }

        ArrayList<Integer> ranks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if(list.get(i).x < list.get(j).x && list.get(i).y < list.get(j).y){
                    cnt++;
                }
            }
            ranks.add(cnt);
        }

        for(int rank : ranks)
            System.out.print(rank + " ");
    }

    public static class Person {
        int x, y;

        Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
