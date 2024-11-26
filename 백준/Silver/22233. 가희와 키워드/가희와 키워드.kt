fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val memo = HashSet<String>()
    repeat(n) {
        memo.add(readln())
    }
    val blog = List(m) { readln().split(",") }

    for (idx in 0 until m) {
        for (word in blog[idx]) { 
            if (word in memo) {
                memo -= word
            }
        }
        println(memo.size)
    }

}
