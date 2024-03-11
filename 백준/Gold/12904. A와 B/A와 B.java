import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String base = br.readLine();
        String target = br.readLine();

        while (target.length() > base.length()) {
            char c = target.charAt(target.length() - 1);

            if (c == 'A') {
                target = target.substring(0, target.length() - 1);
            } else {
                target = target.substring(0, target.length() - 1);
                target = new StringBuilder(target).reverse().toString();
            }
        }
        if (target.equals(base))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
