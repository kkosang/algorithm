fun main() {
    val (n, d, k, c) = readln().split(" ").map { it.toInt() }
    val sushi = IntArray(n) { readLine()!!.toInt() }
    val eated = IntArray(d + 1) { 0 }

    // init
    var count = 0
    for (i in 0 until k) {
        if (eated[sushi[i]] == 0) {
            count++
        }
        eated[sushi[i]]++
    }

    var maxLen = if (eated[c] == 0) count + 1 else count

    for (i in 1 until n) {
        val end = (i + k - 1) % n
        if (eated[sushi[end]] == 0) {
            count++
        }
        eated[sushi[end]]++

        eated[sushi[i - 1]]--
        if (eated[sushi[i - 1]] == 0) {
            count--
        }

        maxLen = maxOf(maxLen, if (eated[c] == 0) count + 1 else count)
    }

    println(maxLen)
}
