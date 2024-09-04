fun main() {
    val t = readln().toInt()
    val dp = Array(10001) { IntArray(4) }
    val sb = StringBuilder()

    dp[0][0] = 1 // 아무것도 사용하지 않는 경우
    dp[1][1] = 1
    dp[2][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 1
    dp[3][3] = 1

    for (i in 4..10000) {
        dp[i][1] = dp[i - 1][1]
        dp[i][2] = dp[i - 2][1] + dp[i - 2][2]
        dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]
    }

    val input = IntArray(t) {
        readln().toInt()
    }

    for (n in input) {
        sb.appendLine(dp[n][1] + dp[n][2] + dp[n][3])
    }
    print(sb)
}
