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
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> dontSee = new ArrayList<>();
        ArrayList<String> dontLook = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            dontSee.add(name);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            dontLook.add(name);
        }

        // 공통원소 구하기
        Collections.sort(dontLook);
        Collections.sort(dontSee);
        ArrayList<String> answer = new ArrayList<>();

        int lt = 0, rt = 0;
        while (lt < n && rt < m) {
            String a = dontSee.get(lt);
            String b = dontLook.get(rt);
            // 문자 비교하기
            int result = a.compareTo(b);
            if (result < 0) {
                lt++;
            } else if (result > 0) {
                rt++;
            } else {
                answer.add(a);
                lt++;
                rt++;
            }
        }

        System.out.println(answer.size());
        for (String name : answer) {
            System.out.println(name);
        }
    }
}
