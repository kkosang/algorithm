class Solution {
    fun solution(X: String, Y: String): String {
        val answer = StringBuilder()
        val cntX = IntArray(10)
        val cntY = IntArray(10)

        for (ch in X) {
            cntX[ch - '0']++
        }
        for (ch in Y) {
            cntY[ch - '0']++
        }

        for (num in 9 downTo 0) {
            val common = minOf(cntX[num], cntY[num])
            repeat(common) { answer.append(num) }
        }

        return when {
            answer.isEmpty() -> "-1"
            answer.all { it == '0' } -> "0"
            else -> answer.toString()
        }
    }
}