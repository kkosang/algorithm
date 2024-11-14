fun main() {
    var input = readln()
    val aeoui = listOf('a', 'e', 'o', 'u', 'i')
    val sb = StringBuilder()

    while (input != "end") {
        when (isValidInput(input, aeoui)) {
            true -> {
                sb.appendLine("<${input}> is acceptable.")
            }

            false -> {
                sb.appendLine("<${input}> is not acceptable.")
            }
        }

        input = readln()
    }

    println(sb)
}

private fun isContinuousVowel(input: String): Boolean {
    for (idx in input.indices) {
        val char = input[idx]

        if (idx > 0 && char == input[idx - 1]) {
            if (char != 'e' && char != 'o') return false
        }
    }

    return true
}

private fun containsVowel(input: String, vowel: List<Char>): Boolean {
    return input.any { it in vowel }
}

private fun isContinuousAlpha(input: String, vowel: List<Char>): Boolean {
    var vowelCount = 0
    var count = 0
    input.forEach { alpha ->
        if (alpha in vowel) {
            vowelCount++
            count = 0
        } else { // 자음
            count++
            vowelCount = 0
        }

        if (vowelCount >= 3 || count >= 3) {
            return false
        }
    }

    return true
}

fun isValidInput(input: String, vowel: List<Char>): Boolean {
    if (!containsVowel(input, vowel)) return false
    if (!isContinuousVowel(input)) return false
    if (!isContinuousAlpha(input, vowel)) return false

    return true
}