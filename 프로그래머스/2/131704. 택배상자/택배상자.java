import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new ArrayDeque<>();
        
      
        for(int i=1; i<=order.length+1;i++){
            q.add(i);
        }
        
        while(!q.isEmpty()){
            while(!s.isEmpty() && s.peek() == order[answer])
            {
                s.pop();
                answer++;
            }
            s.push(q.poll());
        }
        
        return answer;
    }
}