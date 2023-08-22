import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* [#1] 순열 구하기
10이하의 N개 자연수 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력
 * */
public class No8_06 {
    static int[] pm, arr;
    static boolean[] check;
    static int n, m;

    public static void dfs(int L) {
        if(L == m){ // 리프노드 까지 도달 한 경우
            for(int x: pm) System.out.print(x +" ");
            System.out.println();
        }
        else{
            for (int i = 0; i < n; i++) { // 전체 가짓수 만큼 뻗기
                if(!check[i]){ // 사용하지 않은 숫자만
                    pm[L] = arr[i]; // 순열
                    check[i] = true; // 사용하기
                    dfs(L+1);
                    check[i] = false; // 사용풀기
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n개중 m개 뽑기
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        pm = new int[m]; // 최종 만들어질 순열
        dfs(0);
    }
}

