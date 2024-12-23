import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m, start) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visitedDFS = BooleanArray(n + 1) // n
    val visitedBFS = BooleanArray(n + 1)
    val sb = StringBuilder()

    repeat(m) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        graph[from].add(to)
        graph[to].add(from)
    }

    graph.forEach { it.sort() }

    dfs(graph, start, visitedDFS, sb)
    sb.appendLine()
    bfs(graph, start, visitedBFS, sb)
    print(sb)
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray, sb: StringBuilder) {
    visited[v] = true
    sb.append("${v} ")

    for (next in graph[v]) {
        if (!visited[next]) {
            dfs(graph, next, visited, sb)
        }
    }
}

fun bfs(graph: Array<MutableList<Int>>, start: Int, visited: BooleanArray, sb: StringBuilder) {
    val q: Queue<Int> = LinkedList()
    q.add(start)
    visited[start] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()
        sb.append("${cur} ")
        
        for (next in graph[cur]) {
            if (!visited[next]) {
                visited[next] = true
                q.add(next)
            }
        }
    }
}
