import java.io.BufferedReader
import java.io.InputStreamReader

var cntZero = 0
var cntOne = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toCharArray()

    val sb = StringBuilder()
    for (s in input) {
        when (s) {
            '0' -> cntZero++
            '1' -> cntOne++
        }
    }

    var thanosZero = cntZero / 2
    var thanosOne = cntOne / 2

    for (c in input) {
        if (c == '0' && thanosZero > 0) {
            sb.append(c)
            thanosZero--
        }
        if (c == '1') {
            if (thanosOne > 0) {
                thanosOne--
            } else {
                sb.append(c)
            }
        }
    }

    println(sb)
}