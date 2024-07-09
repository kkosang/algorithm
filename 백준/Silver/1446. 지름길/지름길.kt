import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

const val INF = Int.MAX_VALUE
val g = Array(10001) { ArrayList<Node>() }
val dist = IntArray(10001) { INF }
var n = 0
var d = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    n = input[0]
    d = input[1]

    repeat(n) {
        val (x, y, c) = br.readLine().split(" ").map { it.toInt() }
        g[x].add(Node(c, y))
    }

    dijkstra()
}

fun dijkstra() {
    val pq = PriorityQueue<Node>()
    // 출발지점의 cost 0
    dist[0] = 0

    for (i in 0..d) {
        if (i != 0)
            dist[i] = minOf(dist[i], dist[i - 1] + 1) // 현재거리와, 이전 거리값에서 한칸 이동한 값의 최솟값

        if (g[i].isNotEmpty()) {
            pq.add(Node(dist[i],i))

            while (pq.isNotEmpty()) {
                val (distance, now) = pq.poll()!!
                if (distance > dist[now]) continue


                for (next in g[now]) {
                    if (next.cost > d) continue

                    // 현재 거리 + 다음 노드의 거리
                    val cost = distance + next.dist
                    // 거리배열에 최솟값 저장
                    if (cost < dist[next.cost]) {
                        pq.add(Node(cost, next.cost))
                        dist[next.cost] = cost
                    }
                }
            }
        }
    }
    print(dist[d])
}

data class Node(val dist: Int, val cost: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.dist.compareTo(other.dist)
    }
}

