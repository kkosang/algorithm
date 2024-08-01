val n = readln().toInt()
val answer = ArrayList<Int>()
val arr = IntArray(n + 1) { 0 }
val visited = BooleanArray(n + 1) { false }

fun main() {
    for (i in 1..n) {
        arr[i] = readln().toInt()
    }

    for (i in 1..n) {
        visited[i] = true
        dfs(i, i)
        visited[i] = false
    }

    println(answer.size)
    answer.sorted().forEach {
        println(it)
    }

}

fun dfs(s: Int, target: Int) {
    if (visited[arr[s]] == false) {
        visited[arr[s]] = true
        dfs(arr[s], target)
        visited[arr[s]] = false
    }

    if (arr[s] == target) {
        answer.add(s)
    }
}
