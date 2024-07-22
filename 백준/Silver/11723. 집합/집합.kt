import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()

    var bitSet = 0
    val sb = StringBuilder()

    repeat(cnt) {
        val input = br.readLine().split(" ")
        when (input[0]) {
            "add" -> {
                val e = input[1].toInt() - 1
                bitSet = bitSet or (1 shl e)
            }

            "check" -> {
                val e = input[1].toInt() - 1
                if (bitSet and (1 shl e) != 0) sb.appendLine(1) else sb.appendLine(0)
            }

            "remove" -> {
                val e = input[1].toInt() - 1
                bitSet = bitSet and (1 shl e).inv() // 값을 반전시킴 1 -> 0 , 0 -> 1
            }

            "toggle" -> {
                val e = input[1].toInt() - 1
                bitSet = bitSet xor (1 shl e)  // 특정 비트를 1로 설정하고 xor 연산
            }

            "all" -> {
                bitSet = (1 shl 20) - 1 // 21번째 값이 1이되고, -1을 하면 21번째 0, 20번째까지 모든 값이 1
            }

            "empty" -> {
                bitSet = 0
            }
        }
    }
    println(sb.toString())
}
