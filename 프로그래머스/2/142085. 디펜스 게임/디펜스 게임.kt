import java.util.PriorityQueue

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer: Int = 0
        answer = defense(n,k,enemy)
        return answer
    }
    
      fun defense(n:Int, k:Int,enemy:IntArray):Int{
        val pq = PriorityQueue<Int>(reverseOrder())
        var arm = n
        var shield = k
        
        for(round in enemy.indices){
            arm -= enemy[round]
            pq.add(enemy[round])
            
            if(arm<0){
                if(shield > 0){
                    arm += pq.poll()
                    shield--
                }else{
                    return round
                }
            }
        }
        return enemy.size
    }
}