import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val move = IntArray(101) { it } // 1~100
    val visited = BooleanArray(101)

    repeat(n + m) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        move[from] = to // 이동경로
    }

    print(bfs(move, visited))
}

fun bfs(move: IntArray, visited: BooleanArray): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList() // 현재위치, 주사위 횟수
    q.add(1 to 0)

    while (q.isNotEmpty()) {
        val (cur, cnt) = q.poll()!!

        if (cur == 100) return cnt

        for (dice in 1..6) {
            val next = cur + dice
            if (next <= 100 && !visited[move[next]]) {
                visited[move[next]] = true
                q.add(move[next] to cnt + 1)
            }
        }
    }

    return 1
}
