
fun main() {
    val length = readln().toInt()
    val lamps = readln().toInt()
    val positions = readln().split(" ").map { it.toInt() }

    var height = Int.MAX_VALUE
    var lt = 0
    var rt = length

    while (lt <= rt) {
        val mid = (lt + rt) / 2

        if (isCovered(length, positions, mid)) { // 높이를 줄여야함
            height = mid
            rt = mid - 1
        } else {
            lt = mid + 1
        }
    }

    println(height)
}

private fun isCovered(length: Int, positions: List<Int>, h: Int): Boolean {
    if (positions.first() - h > 0) return false

    for (i in 0 until positions.size - 1) {
        //if (positions[i] + h < positions[i + 1]) return false
        if (positions[i] + h < positions[i + 1] - h) return false
    }

    if (positions.last() + h < length) return false

    return true
}