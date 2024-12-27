import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val dist = IntArray(n + 1) { Int.MAX_VALUE }

    repeat(m) {
        val (from, to, cost) = readln().split(" ").map { it.toInt() }
        graph[from].add(Pair(to, cost))
        graph[to].add(Pair(from, cost))
    }

    println(dijkstra(graph, dist, n))
}

fun dijkstra(graph: Array<MutableList<Pair<Int, Int>>>, dist: IntArray, n: Int): Int {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    dist[1] = 0 // 시작노드의 거리 0

    pq.add(0 to 1) // 현재비용,노드번호

    while (pq.isNotEmpty()) {
        val (curCost, curNode) = pq.poll()!!
        if (curCost > dist[curNode]) continue

        for ((nextNode, nextCost) in graph[curNode]) {
            val newCost = nextCost + curCost
            if (newCost < dist[nextNode]) {
                dist[nextNode] = newCost
                pq.add(Pair(newCost, nextNode))
            }
        }
    }
    return dist[n]
}
