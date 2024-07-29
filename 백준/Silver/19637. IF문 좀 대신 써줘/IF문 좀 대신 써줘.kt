fun main() {
    val sb = StringBuilder()
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Node>()
    repeat(n) {
        val input = readln().split(" ")
        list.add(Node(badge = input[0], condition = input[1].toInt()))
    }

    repeat(m) {
        val score = readln().toInt()
        sb.appendLine(badge(list, score))
    }
    println(sb)
}

fun badge(list: List<Node>, score: Int): String {
    var lt = 0
    var rt = list.size - 1

    while (lt <= rt) {
        val mid = (lt + rt) / 2
        if (list[mid].condition >= score) {
            rt = mid - 1
        } else {
            lt = mid + 1
        }
    }

    return list[lt].badge
}

class Node(val badge: String, val condition: Int)
