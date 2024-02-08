import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<city>[] graph;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a].add(new city(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(n,start,end);
        System.out.println(sb);
    }

    public static void Dijkstra(int n, int start,int end) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<city> pq = new PriorityQueue<>();
        pq.offer(new city(start, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().v;

            if (check[now]) continue;
            check[now] = true;

            for (city next : graph[now]) {
                if (dist[next.v] > dist[now] + next.cost) {
                    dist[next.v] = dist[now] + next.cost;

                    pq.offer(new city(next.v, dist[next.v]));
                }
            }
        }

        sb.append(dist[end]);
    }

    public static class city implements Comparable<city> {
        int v, cost;

        city(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(city o) {
            return this.cost - o.cost;
        }
    }
}
