import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();
                map.put(category, map.getOrDefault(category, 0) + 1);
            }
            int combi = countCombinations(map);
            System.out.println(combi);
        }
    }

    private static int countCombinations(Map<String, Integer> map) {
        int result = 1;

        // 선택 + 선택하지 않음(=1)
        for (int count : map.values()) {
            result *= (count + 1);
        }

        return result - 1; // 모두 선택하지 않은 경우
    }
}
