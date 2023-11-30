import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 비용 1 <= c < 10^6이고, 도로의 개수 5x10^5니까 cost는 long타입으로
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int sV = 0;
        long totalCost = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) { // 시작지점과 비용
                sV = a;
            }

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
            totalCost += c;
        }

        // 프림
        boolean check[] = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(sV, 0));
        long answer = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int ev = cur.to;

            if (!check[ev]) {
                check[ev] = true;
                answer += cur.cost;

                for (Edge ob : graph.get(cur.to)) {
                    if (!check[ob.to]) {
                        pq.add(new Edge(ob.to, ob.cost));
                    }
                }
            }
        }

        boolean isSave = true;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                isSave = false;
            }
        }

        if(isSave){
            System.out.println(totalCost - answer);
        }else{
            System.out.println(-1);
        }
    }

    public static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }
}
