import kotlin.math.abs
fun main() {
    val n = readln().toInt()
    val word = readln()
    val countChar: MutableMap<Char, Int> = mutableMapOf()
    var answer = 0

    for (char in word) {
        countChar[char] = countChar.getOrDefault(char, 0) + 1
    }

    repeat(n - 1) {
        val nextWord = readln()
        val tempCount = mutableMapOf<Char, Int>()

        for (char in nextWord) {
            tempCount[char] = tempCount.getOrDefault(char, 0) + 1
        }

        val lengthDiff = abs(word.length - nextWord.length)
        if (lengthDiff > 1) return@repeat


        var diffCount = 0
        countChar.forEach { (char, count) -> 
            val nextCount = tempCount.getOrDefault(char, 0)
            diffCount += abs(count - nextCount)
        }

        // 비교 단어에만 있는 문자가 있을 경우 카운트
        tempCount.forEach { (char, count) ->
            if (char !in countChar) diffCount += count
        }

        if (diffCount <= 2) {
            answer++
        }
    }

    println(answer)
}
