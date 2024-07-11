import java.io.BufferedReader
import java.io.InputStreamReader

var cntA = 0
var cntB = 0
var answer = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toCharArray()

    cntA = input.count { it == 'a' }
    cntB = input.take(cntA).count { it == 'b' }
    answer = cntB

    for (i in 1 until input.size) {
        if (input[i - 1] == 'b') { // 이전의 값
            cntB--
        }

        if (input[(i + cntA - 1) % input.size] == 'b') { // 마지막 값
            cntB++
        }
        answer = minOf(answer, cntB)
    }

    println(answer)
}