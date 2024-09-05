// 8
// BBRBBBBR

val n = readln().toInt()

fun main() {
    val ball = readln().toCharArray()
    val redCount = move(ball, 'R')
    val blueCount = move(ball, 'B')
    println(minOf(redCount, blueCount))
}

fun move(ball: CharArray, color: Char) = minOf(countAtFront(ball, color), countAtBack(ball, color))

private fun countAtFront(ball: CharArray, color: Char): Int {
    var cnt = 0
    var start = false
    for (i in 0..n - 1) {
        if (ball[i] != color) start = true
        if (start) {
            if (ball[i] == color) cnt++
        }
    }
    return cnt
}

private fun countAtBack(ball: CharArray, color: Char): Int {
    var cnt = 0
    var start = false
    for (i in n - 1 downTo 0) {
        if (ball[i] != color) start = true
        if (start) {
            if (ball[i] == color) cnt++
        }
    }
    return cnt
}