
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val countries = mutableListOf<List<Int>>()
    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }
        countries.add(input)
    }

    val target = countries.first { it[0] == k }
    var rank = 1
    for (country in countries) {
        if (country[1] > target[1] ||
            (country[1] == target[1] && country[2] > target[2]) ||
            (country[1] == target[1] && country[2] == target[2] && country[3] > target[3])
        ) {
            rank++
        }
    }

    println(rank)
}