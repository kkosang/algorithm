fun main() {
    val size = readln().toInt()
    val map = Array(size) { readln().toCharArray() }
    
    val heart = findHeart(map)
    val arms = findArms(map, heart)
    val waist = findWaist(map, heart)
    val legs = findLegs(map, heart, waist)

    println("${heart.first + 1} ${heart.second + 1}")
    println("${arms.first} ${arms.second} ${waist} ${legs.first} ${legs.second}")
}

private fun findHeart(map: Array<CharArray>): Pair<Int, Int> {
    for (row in map.indices) {
        for (col in map[row].indices) {
            if (map[row][col] == '*') return row + 1 to col
        }
    }

    return 0 to 0
}

private fun findArms(map: Array<CharArray>, heart: Pair<Int, Int>): Pair<Int, Int> {
    var left = 0
    var right = 0
    for (col in heart.second - 1 downTo 0) {
        if (map[heart.first][col] == '*') left++
        else break
    }
    for (col in heart.second + 1 until map.size) {
        if (map[heart.first][col] == '*') right++
        else break
    }

    return left to right
}

private fun findWaist(map: Array<CharArray>, heart: Pair<Int, Int>): Int {
    var waist = 0
    for (row in heart.first + 1 until map.size) {
        if (map[row][heart.second] == '*') waist++
        else break
    }

    return waist
}

private fun findLegs(map: Array<CharArray>, heart: Pair<Int, Int>, waist: Int): Pair<Int, Int> {
    var left = 0
    var right = 0
    for (row in heart.first + waist + 1 until map.size) {
        if (map[row][heart.second - 1] == '*') left++
        if (map[row][heart.second + 1] == '*') right++
    }

    return left to right
}