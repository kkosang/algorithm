import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map { it.toInt() }
    val ans = IntArray(n)

    for (i in 0 until n) {
        var cnt = 0
        for (j in 0 until n) {
            if (ans[j] == 0) {
                if (cnt == arr[i]) {
                    if (ans[j] == 0) {
                        ans[j] = i + 1
                        break
                    }
                } else {
                    cnt++
                }
            }
        }
    }
    ans.forEach { print("$it ") }
}