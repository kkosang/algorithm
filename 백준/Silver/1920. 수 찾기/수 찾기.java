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
        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int b[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m ; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < b.length; i++) {
            int lt =0, rt = a.length-1;
            int mid = 0;
            boolean find = false;
            while (lt<=rt){
                mid = (lt + rt)/ 2;
                if(b[i] < a[mid]){
                    rt = mid -1;
                }else if ( b[i] > a[mid]){
                    lt = mid +1;
                }else{
                    sb.append(1+"\n");
                    find = true;
                    break;
                }
            }
            if(!find)
                sb.append(0+"\n");
        }

        System.out.println(sb);
    }
}
