
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val blog = readln().split(" ").map { it.toInt() }

    var currentSum = blog.take(k).sum()
    var maxSum = currentSum
    var count = 1

    for (i in k until n) {
        currentSum = currentSum - blog[i - k] + blog[i]
        
        if (currentSum > maxSum) {
            maxSum = currentSum
            count = 1
        } else if (currentSum == maxSum) {
            count++
        }
    }

    if (maxSum == 0) {
        println("SAD") 
    } else {
        println(maxSum)
        println(count)
    }
}
