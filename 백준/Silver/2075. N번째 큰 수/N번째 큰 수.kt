import java.util.*

fun main() {
    val n = readln().toInt()
    val pq = PriorityQueue<Int>()

    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }
        input.forEach { number ->
            pq.add(number)
            if(pq.size > n){
                pq.poll()
            }
        }
    }
    
    val answer = pq.poll()
    println(answer)
}