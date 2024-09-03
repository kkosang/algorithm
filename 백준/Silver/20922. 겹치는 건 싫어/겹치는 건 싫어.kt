// n, k
// 1,2,3,4,5,6
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    var cnt = 0
    var lt = 0
    var rt = 0
    var answer = Int.MIN_VALUE

    while (rt < n) {
        val value = map.getOrDefault(arr[rt], 0)

        if (value < k) {
            map[arr[rt]] = value + 1
            cnt++
            rt++
            answer = Math.max(answer, cnt)
        } else {
            map[arr[lt]] = map[arr[lt]]!! - 1
            cnt--
            lt++
        }
    }

    println(answer)
}
