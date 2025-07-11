import java.io.*
import java.util.*

fun main() {
    val totalPerson = readln().toInt()
    val (start, end) = readln().split(" ").map { it.toInt() }
    val lines = readln().toInt()
    val graph = mutableMapOf<Int, MutableList<Int>>()

    repeat(lines) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph.computeIfAbsent(a) { mutableListOf() }.add(b)
        graph.computeIfAbsent(b) { mutableListOf() }.add(a)
    }

    val visited = BooleanArray(totalPerson + 1)

    val result = dfs(start, end, visited, 0, graph)
    println(result)
}

fun dfs(
    cur: Int,
    tar: Int,
    visited: BooleanArray,
    depth: Int,
    graph: MutableMap<Int, MutableList<Int>>
): Int {
    if (cur == tar) return depth
    visited[cur] = true

    for (next in graph[cur] ?: emptyList()) {
        if (!visited[next]) {
            val result = dfs(next, tar, visited, depth + 1, graph)
            if (result != -1) return result
        }
    }

    return -1
}