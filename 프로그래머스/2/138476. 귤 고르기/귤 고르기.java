import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> box = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            int value = box.getOrDefault(tangerine[i],0);
            box.put(tangerine[i],value+1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(box.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int total =0;
        for(int i=0;i<list.size();i++){
            total += list.get(i);
            answer++;
            if(total >= k)
                break;
        }

        return answer;
    }
}