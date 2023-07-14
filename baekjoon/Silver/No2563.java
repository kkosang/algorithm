import java.util.Scanner;

public class No2563 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 색종이 수
        boolean visited[][] = new boolean[100][100];

        int total = 0;
        for (int i = 0; i < n; i++) {
            int px = sc.nextInt(); // x좌표
            int py = sc.nextInt(); // y좌표
            for (int x = px; x < px + 10; x++) {
                for (int y = py; y < py + 10; y++) {
                    if(!visited[x][y]){
                        visited[x][y] = true;
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
    }
}

