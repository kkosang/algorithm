
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val belt = readln().split(" ").map { it.toInt() }.toMutableList()
    val robot = MutableList(n) { false }

    var step = 0
    while (true) {
        step++

        // 벨트 회전, 로봇도
        val last = belt.removeLast()
        belt.add(0, last)

        for (i in n - 2 downTo 0) {
            robot[i + 1] = robot[i]
        }
        robot[0] = false
        robot[n - 1] = false

        // 로봇 이동
        for (i in n - 2 downTo 0) {
            if (robot[i] && !robot[i + 1] && belt[i + 1] >= 1) {
                robot[i] = false
                robot[i + 1] = true
                belt[i + 1]--
            }
        }
        robot[n - 1] = false

        // 로봇 올리기
        if (belt[0] >= 1) {
            robot[0] = true
            belt[0]--
        }

        // 내구도 검사
        if (belt.count { it == 0 } >= k) {
            break
        }
    }

    println(step)
}