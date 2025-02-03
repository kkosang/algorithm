import java.util.LinkedList
import java.util.Queue

class Solution {
    val dy: IntArray = intArrayOf(-1, 0, 1, 0)
    val dx: IntArray = intArrayOf(0, 1, 0, -1)

    fun solution(maps: Array<String>): Int {
        var start = Pair(0, 0)
        var end = Pair(0, 0)
        var lever = Pair(0, 0)

        for (i in maps.indices) {
            for (j in maps[i].indices) {
                when (maps[i][j]) {
                    'S' -> start = Pair(i, j)
                    'E' -> end = Pair(i, j)
                    'L' -> lever = Pair(i, j)
                }
            }
        }


        val leverCnt = bfs(start, lever, maps)
        val endCnt = bfs(lever, end, maps)

        return if (leverCnt == -1 || endCnt == -1) -1 else leverCnt + endCnt
    }

    private fun bfs(s: Pair<Int, Int>, e: Pair<Int, Int>, maps: Array<String>): Int {
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        val visited = Array(maps.size) { BooleanArray(maps[0].length) }
        q.add(Triple(s.first, s.second, 0))
        visited[s.first][s.second] = true

        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.poll()!!
            if (x == e.first && y == e.second) {
                return cnt
            }

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx < 0 || ny < 0 || nx >= maps.size || ny >= maps[0].length) continue
                if (maps[nx][ny] != 'X' && !visited[nx][ny]) {
                    q.add(Triple(nx, ny, cnt + 1))
                    visited[nx][ny] = true
                }
            }
        }
        return -1
    }
}
