
class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val scores: MutableMap<Char, Int> = mutableMapOf()
        val choiceScore = mapOf(1 to 3, 2 to 2, 3 to 1, 4 to 0, 5 to 1, 6 to 2, 7 to 3)

        for (idx in survey.indices) {
            val type = survey[idx]
            val choice = choices[idx]

            when {
                choice < 4 -> { // 첫번째 유형
                    val curScore = scores.getOrDefault(type[0], 0)
                    scores[type[0]] = curScore + choiceScore[choice]!!
                }

                choice > 4 -> {
                    val curScore = scores.getOrDefault(type[1], 0)
                    scores[type[1]] = curScore + choiceScore[choice]!!
                }

                else -> {
                    scores.putIfAbsent(type[0], 0)
                    scores.putIfAbsent(type[1], 0)
                }
            }
        }

        val types = arrayOf("RT", "CF", "JM", "AN")
        for (type in types) {
            val first = type[0]
            val second = type[1]
            val firstScore = scores[first]
            val secondScore = scores[second]

            answer += if ((firstScore ?: 0) >= (secondScore ?: 0)) first else second
        }
        return answer
    }
}
