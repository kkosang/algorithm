import java.io.BufferedReader
import java.io.InputStreamReader

// 20 2
// HHHPPHPHPHPHPHPPH
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(' ').map { it.toInt() }
    val n = input[0]
    val dis = input[1]
    val hp = br.readLine().toCharArray()
    var answer = 0

    for (i in 0 until n) {
        if (hp[i] == 'P') {
            val start = Math.max(i - dis, 0)
            val end = if (i + dis >= n) n - 1 else i + dis
            for (j in start..end) { // 시작부터 끝범위
                if (hp[j] == 'H') {
                    answer++
                    hp[j] = 'E'
                    break
                }
            }
        }
    }
    println(answer)
}