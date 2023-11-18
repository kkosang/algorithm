import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [#2] 두 배열 합치기
https://cote.inflearn.com/contest/10/problem/03-01
* */
public class No3_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int A[] = new int[sizeA];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int sizeB = Integer.parseInt(st.nextToken());
        int B[] = new int[sizeB];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = sumArrays(sizeA, A, sizeB, B);

        printAnswer(answer);

    }

    private static void printAnswer(int[] answer) {
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }

    private static int[] sumArrays(int sizeA, int[] A, int sizeB, int[] B) {
        int answer[] = new int[sizeA + sizeB];

        int i = 0, j = 0, k = 0;
        while (i < sizeA && j < sizeB) {
            if (A[i] > B[j]) {
                answer[k++] = B[j++];
            } else {
                answer[k++] = A[i++];
            }
        }

        while (i < sizeA) {
            answer[k++] = A[i++];
        }

        while (j < sizeB) {
            answer[k++] = B[j++];
        }
        return answer;
    }
}

