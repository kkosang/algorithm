import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* #0 매출액의 종류 -> 시간초과
https://cote.inflearn.com/contest/10/problem/04-03
* */
// value값이 0 이되면 지우기, -> lt증가
public class No4_03 {
    public static ArrayList<Integer> solution(int n, int k, int arr[]) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0, rt;
        for (rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            // 윈도우 밀기
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]); // 키 삭제
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }
}

