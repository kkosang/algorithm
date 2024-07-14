import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(' ').map { it.toInt() }
    val dictionary = mutableMapOf<String, Int>()
    val answer = StringBuilder()

    val minLength = input[1]
    repeat(input[0]) {
        val word = br.readLine()
        if (word.length >= minLength) {
            dictionary[word] = dictionary.getOrDefault(word, 0) + 1
        }
    }

    // 단어가 나온 횟수 비교
    // 단어의 길이
    // 사전 순
    val words = ArrayList<String>(dictionary.keys)
    words.sortWith { w1, w2 ->
        when {
            dictionary[w1] != dictionary[w2] -> dictionary[w2]!!.compareTo(dictionary[w1]!!)
            w1.length != w2.length -> w2.length.compareTo(w1.length)
            else -> w1.compareTo(w2)
        }
    }

    words.forEach { answer.appendLine(it) }
    println(answer)
}