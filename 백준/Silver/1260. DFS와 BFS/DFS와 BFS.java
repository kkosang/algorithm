import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    public  static  void DFS(int [][] graph, int v, boolean []visted){
        // 방문처리
        visted[v] =true;
        sb.append(v+" ");

        for(int j=1;j<graph.length;j++) { // 배열의 행의 개수만큼
            if(graph[v][j] == 1 && visted[j] == false){ // 인접하고 방문하지 않았다면
                DFS(graph,j,visted);
            }
        }
    }

    public static void BFS (int [][]graph,int v, boolean [] visted){
        Queue<Integer> q = new LinkedList<>();

        // 1. 탐색정점을 방문처리 후 큐에 add
        visted[v] = true;
        q.add(v);
        sb.append(v+" ");

        // 큐가 빌때까지
        while(!q.isEmpty()){
            // pop하면서 인접노드 모두 방문처리
            int qx = q.poll(); // 탐색노드
            for(int j=1;j<graph[qx].length;j++){
                if(graph[qx][j] ==1 && visted[j] == false){ // 인접하고 방문하지 않았다면
                    visted[j] = true;
                    q.add(j);
                    sb.append(j).append(" ");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 그래프(2차원) , 방문(1차원) 메모리 할당
        int graph [][] = new int[node+1][node+1];
        boolean visited [] = new boolean[node+1];

        /* 입력 받아서 graph에 저장 하는 방식 */
        // 인접행렬로 그래프 구현
        for(int i=0; i<line;i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            /* StringTokenizer str을 해야하는 이유?
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());*/
            // 인접노드 1로 세팅
            graph[a][b] = graph[b][a] = 1;
        }

        DFS(graph,v,visited);
        sb.append("\n");
        // ★ visted 초기화 안했었음
        visited = new boolean[node+1];
        BFS(graph,v,visited);
        System.out.println(sb);
    }
}