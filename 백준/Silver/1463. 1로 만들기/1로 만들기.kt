import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val visited = BooleanArray(n + 1) { false }

    q.add(n to 0)
    visited[n] = true

    while (q.isNotEmpty()) {
        val (curNum, curCnt) = q.poll()
        if (curNum == 1) {
            println(curCnt)
            return
        }

        if (curNum % 3 == 0 && !visited[curNum / 3]) {
            visited[curNum / 3] = true
            q.add(curNum / 3 to curCnt + 1)
        }
        if (curNum % 2 == 0 && !visited[curNum / 2]) {
            visited[curNum / 2] = true
            q.add(curNum / 2 to curCnt + 1)
        }
        if (!visited[curNum - 1]) {
            visited[curNum - 1] = true
            q.add(curNum - 1 to curCnt + 1)
        }
    }
}
