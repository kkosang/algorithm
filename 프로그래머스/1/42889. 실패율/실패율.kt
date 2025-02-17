class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val totalPlayers = stages.size
        var remainingPlayers = totalPlayers
       
    return (1..N).map { stage ->
        val failed = stages.count { it == stage }  
        val failureRate = if (remainingPlayers == 0) 0.0 else failed.toDouble() / remainingPlayers
        remainingPlayers -= failed  
        stage to failureRate
        } 
        .sortedByDescending { it.second }  // 실패율 내림차순
        .map { it.first }  
        .toIntArray()
    }
}