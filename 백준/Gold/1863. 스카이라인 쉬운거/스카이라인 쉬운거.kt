import java.util.*

// 같은 높이의 건물 처리
val n = readln().toInt()
val stack = Stack<Int>()

fun main() {
    var answer = 0

    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        answer += countTowers(x, y)

        if (stack.isEmpty() || stack.peek() != y) {
            stack.add(y)
        }
    }

    // 남아 있는 스택에서 처리되지 않은 건물 처리
    answer += countTowers(0, 0)

    println(answer)
}

private fun countTowers(x: Int, y: Int): Int {
    var count = 0
    while (stack.isNotEmpty() && stack.peek() > y) {
        stack.pop()
        count++
    }
    return count
}