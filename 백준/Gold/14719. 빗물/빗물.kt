import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")
    val height = input[0].toInt()
    val width = input[1].toInt()
    // l,r중 최소
    // 최소 - 현재 => 고일 수 있는 물의 높이
    val wall = br.readLine().split(" ").map { it.toInt() }

    var rain = 0
    for (i in 1 until width - 1) {
        var lt = 0
        var rt = 0

        for (j in 0 until i) {
            lt = maxOf(lt, wall[j])
        }

        for (j in i + 1 until width) {
            rt = maxOf(rt, wall[j])
        }
        val min = minOf(lt, rt)
        rain += if (min - wall[i] >= 0) min - wall[i] else 0

        /*if (heights[i] < leftHeight && heights[i] < rightHeight) {
            rain += minOf(leftHeight, rightHeight) - heights[i]
        }*/
    }
    println(rain)
}

