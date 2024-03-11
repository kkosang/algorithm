import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        String baseStr = "IOI";
        for (int i = 1; i < n; i++) {
            baseStr += "OI";
        }
       
        int count = 0;
        int index = str.indexOf(baseStr);

        while (index != -1) {
            count++;
            index = str.indexOf(baseStr, index + 1);
        }

        System.out.println(count);
    }
}
