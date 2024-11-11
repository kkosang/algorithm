
fun main() {
    val T = readln().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val input = readln().split(" ").map { it.toInt() }
        val case = input[0]
        val students = input.subList(1, input.size)

        val line = mutableListOf<Int>()
        val count = sortedCount(line, students)
        
        sb.appendLine("$case $count")
    }

    println(sb)
}

private fun sortedCount(line: MutableList<Int>, students: List<Int>): Int {
    var count = 0

    students.forEach { student ->
        val position = insertPosition(line, student)
        count += line.size - position
        line.add(position, student)
    }

    return count
}

private fun insertPosition(line: List<Int>, student: Int): Int {
    for (i in line.indices) {
        if (student < line[i]) {
            return i
        }
    }

    return line.size // 맨 뒤에 추가되는 경우
}
