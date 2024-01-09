import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = 0; 
        int rt = people.length-1;
        int cnt=0;

        while (lt <= rt) {
            if (people[lt] + people[rt] <= limit) {
                lt++;
                rt--;
            } else {
                rt--;
            }
            cnt++; 
        }
        
        return cnt;
    }
}