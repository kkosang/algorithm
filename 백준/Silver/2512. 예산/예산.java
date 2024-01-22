import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a[] = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        int lt = 0, rt = a[n];
        int ans = 0;
        while (lt <= rt){
            int mid = (lt + rt)/2;
            int sum = 0;

            for(int i : a){
                sum += Math.min(i,mid);
            }

            if(sum <= total){
                ans = mid;
                lt = mid +1;
            }else{
                rt = mid-1;
            }
        }

        System.out.println(ans);
    }
}
