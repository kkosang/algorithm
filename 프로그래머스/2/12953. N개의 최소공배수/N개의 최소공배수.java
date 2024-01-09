import java.util.*;
class Solution {
   public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];
        for (int i=0; i<arr.length-1; i++) {
            int num = gcd(answer, arr[i + 1]);
            answer = (answer * arr[i + 1]) / num;
        }
        return answer;
    }
    
    public static int gcd(int n1, int n2) {
        if  (n1 % n2 == 0) {
            return n2;
        }
        return gcd(n2, n1%n2);
    }
}