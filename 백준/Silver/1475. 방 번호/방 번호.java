import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] num = br.readLine().toCharArray();
        int[] numSet = new int[10];

        for (int i = 0; i < num.length; i++) {
            int idx = num[i] - '0';
            if (idx == 9) {
                numSet[6]++;
            } else {
                numSet[idx]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 9; i++) {
            if (i == 6) {
                if (numSet[i] % 2 == 0) {
                    max = Math.max(max, numSet[i] / 2);
                } else {
                    max = Math.max(max, numSet[i] / 2 + 1);
                }
            } else {
                max = Math.max(max, numSet[i]);
            }
        }
        System.out.println(max);
    }
}
