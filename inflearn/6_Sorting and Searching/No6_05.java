import java.util.HashMap;
import java.util.Scanner;

/* [#2] 중복확인
https://cote.inflearn.com/contest/10/problem/06-05
#1 -> 정렬해서 인접한 두 값 비교
#2 -> 해시맵 사용해서 value가 1보다 큰경우
* */
public class No6_05 {
    public static boolean solution(int n, int arr[]) {
        boolean answer = true;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) > 1) answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean check = solution(n, arr);
        if (check) System.out.println("U");
        else System.out.println("D");
    }
}

