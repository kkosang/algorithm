class Solution {
    fun solution(s: String): Int {
        val number = mapOf<String, String>(
            "zero" to "0",
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )

        var answer = s
        for ((word, num) in number) {
            if (s.contains(word)) {
                answer = answer.replace(word, num)
            }
        }
        return answer.toInt()
    }
}