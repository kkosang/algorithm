class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        var lt = 0
        var rt = 0
        var sum = 0
        var minLength = Int.MAX_VALUE
        
        while(rt < sequence.size){
            sum += sequence[rt]
                     
            while(sum > k && lt<=rt){
                sum -= sequence[lt]
                lt++
            }
            
            if(sum == k){
                val length = rt-lt
                if(length < minLength){
                    minLength = length
                    answer = intArrayOf(lt, rt)
                }
            }
            
            rt++
        }
      
        return answer
    }
}