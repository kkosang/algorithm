
fun main() {
    val T = readln().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val input = readln().split(" ").map { it.toInt() }
        val case = input[0]
        val students = input.subList(1, input.size)
        var count = 0

        val line = mutableListOf<Int>()
        students.forEach { student ->
            // 삽입 위치 찾기
            var position = line.size
            for (i in line.indices) {
                if (student < line[i]) {
                    position = i
                    break
                }
            }
            count = count + line.size - position
            line.add(position, student)
        }

        sb.appendLine("$case $count")
    }

    println(sb)
}