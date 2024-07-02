import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val results = mutableListOf<Int>()

    repeat(t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val b = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        b.sort()

        var count = 0
        for (element in a) {
            count += countLessThan(b, element)
        }
        results.add(count)
    }

    results.forEach { println(it) }
}

fun countLessThan(b: IntArray, target: Int): Int {
    var left = 0
    var right = b.size

    while (left < right) {
        val mid = (left + right) / 2
        if (b[mid] < target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}