fun main() {
    val (n, newScore, p) = readln().split(" ").map { it.toInt() }

    if (n == 0) {
        println(1)
        return
    } else {
        val scores = readln().split(" ").map { it.toInt() }.toMutableList()
        var rank = 1
        var count = 0

        for (score in scores) {
            if (score > newScore) rank++
            else if (score == newScore) rank
            else break
            count++
        }

        if (count == p && scores.last() >= newScore) {
            println(-1)
        } else {
            println(rank)
        }
    }
}