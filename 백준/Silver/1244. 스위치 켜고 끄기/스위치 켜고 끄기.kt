fun main() {
    val n = readln().toInt()
    val switch = readln().split(" ").map { it.toInt() }.toMutableList()
    val n2 = readln().toInt()

    repeat(n2) {
        val (st, num) = readln().split(" ").map { it.toInt() }
        when (st) {
            1 -> {
                for (idx in switch.indices) {
                    if ((idx + 1) % num == 0) {
                        switch[idx] = 1 - switch[idx]
                    }
                }
            } // 남자
            2 -> {
                var left = num - 2
                var right = num
                switch[num - 1] = 1 - switch[num - 1]
                while (left >= 0 && right < n && switch[left] == switch[right]) {
                    switch[left] = 1 - switch[left]
                    switch[right] = 1 - switch[right]
                    left--
                    right++
                }
            } // 여자
        }
    }

    for (i in switch.indices) {
        if (i % 20 == 0 && i != 0) println()
        print("${switch[i]} ")
    }
}