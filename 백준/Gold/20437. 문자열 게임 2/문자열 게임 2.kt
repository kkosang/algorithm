fun main() {
    val T = readln().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val word = readln().toCharArray()
        val k = readln().toInt()
        val alpha = IntArray(26) { 0 }

        for (ch in word) {
            alpha[ch - 'a']++
        }

        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (c in 'a'..'z') {
            if (alpha[c - 'a'] < k) continue

            var count = 0
            var start = 0

            for (end in word.indices) {
                if (word[end] == c) count++ // 찾으면 count 증가

                if (count == k) {
                    while (word[start] != c) {
                        start++
                    }
                    val length = end - start + 1
                    min = minOf(min, length)
                    max = maxOf(max, length)
                    count-- 
                    start++ 
                }
            }
        }

        if (min == Int.MAX_VALUE) {
            sb.appendLine(-1)
        } else {
            sb.appendLine("$min $max")
        }
    }
    print(sb)
}
