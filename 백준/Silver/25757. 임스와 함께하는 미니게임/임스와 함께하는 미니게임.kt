fun main() {
    val (n, game) = readln().split(" ")
    val players: HashSet<String> = HashSet()

    repeat(n.toInt()) {
        val input = readln()
        players.add(input)
    }

    var gameCount = 0
    when (game) {
        "Y" -> {
            gameCount = players.count()
        }

        "F" -> {
            gameCount = players.count() / 2
        }

        "O" -> {
            gameCount = players.count() / 3
        }
    }

    println(gameCount)
}