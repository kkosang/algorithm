
class Solution {
    fun solution(n: Int): Long {
        val dp  = Array(2001){0L}
        dp[1] = 1
        dp[2] = 2

        for(i in 3..n){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567
        }

        return dp[n]
    }
}