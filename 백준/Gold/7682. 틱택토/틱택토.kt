
fun main() {

    while (true) {
        val input = readln().trim()
        if (input == "end") break

        when (isCountValid(input)) {
            true -> {
                if (isGameValid(input)) {
                    println("valid")
                } else {
                    println("invalid")
                }
            }

            false -> {
                println("invalid")
            }
        }
    }
}

private fun isCountValid(board: String): Boolean {
    val xCount = board.count { char -> char == 'X' }
    val oCount = board.count { char -> char == 'O' }

    return xCount == oCount || xCount == oCount + 1
}

private fun isGameValid(board: String): Boolean {
    val xWin = isWin(board, 'X')
    val oWin = isWin(board, 'O')
    val xCount = board.count { it == 'X' }
    val oCount = board.count { it == 'O' }

    return when {
        xWin && oWin -> false
        xWin -> xCount == oCount + 1
        oWin -> xCount == oCount
        else -> { // 무승부
            board.none { it == '.' }
        }
    }
}

private fun isWin(board: String, player: Char): Boolean {
    val lines = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // 가로
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // 세로
        listOf(0, 4, 8), listOf(2, 4, 6) // 대각선
    )

    return lines.any { line -> line.all { idx -> board[idx] == player } }
}
