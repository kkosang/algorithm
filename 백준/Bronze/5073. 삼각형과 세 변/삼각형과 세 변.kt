fun main() {
    val sb = StringBuilder()

    while (true) {
        val (x, y, z) = readln().split(" ").map { it.toInt() }

        if (x == 0 && y == 0 && z == 0) break
        if (x + y <= z || y + z <= x || x + z <= y) {
            sb.appendLine("Invalid")
        } else {
            if (x == y && y == z) {
                sb.appendLine("Equilateral")
            } else if (x == y || x == z || y == z) {
                sb.appendLine("Isosceles")
            } else {
                sb.appendLine("Scalene")
            }
        }
    }
    println(sb)
}