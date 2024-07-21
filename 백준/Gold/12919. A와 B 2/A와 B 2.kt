import java.io.BufferedReader
import java.io.InputStreamReader

var answer = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val base = br.readLine()
    var target = br.readLine()

    dfs(base, target)
    println(answer)
}

fun dfs(base: String, target: String) {
    if (base.length == target.length) {
        if (base == target) answer = 1
        return
    }

    if (target.last() == 'A') {
        dfs(base, target.substring(0, target.length - 1))
    }

    if (target.first() == 'B') {
        dfs(base, target.reversed().substring(0, target.length - 1))
    }
}
