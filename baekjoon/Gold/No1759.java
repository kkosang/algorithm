import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.*;

/* [#1] 암호만들기
https://www.acmicpc.net/problem/1759
* */
public class No1759 {

    static int L;
    static int C;
    static int check[];
    static char arr[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new char[C];
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        DFS(0, "");
    }

    public static void DFS(int idx, String s) {
        if (s.length() == L) {
            if (check(s)) {
                System.out.println(s);
                return;
            }
        }

        if (idx >= C) return;
        DFS(idx + 1, s + arr[idx]);// 만든경우
        DFS(idx + 1, s); // 못만든경우
    }

    public static boolean check(String s) {
        int mo = 0, ja = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            } else ja++;
        }
        if (mo >= 1 && ja >= 2) return true;
        else return false;
    }

}

