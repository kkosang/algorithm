import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue pq = new PriorityQueue();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) { // 연산의 개수
            int temp = Integer.parseInt(br.readLine());
            
            if (temp > 0) {
                pq.add(temp);
            } else if (temp == 0 && !pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
