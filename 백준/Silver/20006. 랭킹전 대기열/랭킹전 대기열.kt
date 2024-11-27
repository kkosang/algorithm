
fun main() {
    val (p, capacity) = readln().split(" ").map { it.toInt() }
    val players = mutableListOf<Pair<Int, String>>()

    repeat(p) {
        val (level, name) = readln().split(" ")
        players.add(level.toInt() to name)
    }

    val rooms = mutableListOf<MutableList<Pair<Int, String>>>()

    for (player in players) {
        // 수용가능한지
        val room = rooms.find { it.size < capacity && player.first in (it.first().first - 10)..(it.first().first + 10) }

        if (room != null) {
            room.add(player)
        } else {
            rooms.add(mutableListOf(player))
        }
    }

    for(room in rooms){
        println(if(room.size == capacity) "Started!" else "Waiting!")
        room.sortBy { it.second }
        room.forEach { player -> println("${player.first} ${player.second}") }
    }
}