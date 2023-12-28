import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();
        int idx = 0;
        
        for(int i = 0; i<numbers.length;i++){
            int cur = numbers[i];
           
            while(!s.isEmpty() && numbers[s.peek()] < cur){
                answer[s.pop()] = cur;
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            answer[s.pop()] = -1;
        }
          
        return answer;
    }
}