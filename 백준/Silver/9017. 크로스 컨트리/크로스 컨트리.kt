fun main() {
    val T = readln().toInt()


    repeat(T) {
        val size = readln().toInt()
        val runners = readln().split(" ").map { it.toInt() }
        val teams: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        val validTeams = runners.groupingBy { it }.eachCount().filterValues { it >= 6 }.keys

        val filteredRanks = runners.filter { it in validTeams }
        val ranks = filteredRanks
            .withIndex()
            .groupBy({ it.value }, { it.index + 1 })

        var winner = Triple(201, Int.MAX_VALUE, Int.MAX_VALUE) // 팀,점수,5등

         for (team in ranks) {
             val score = team.value.take(4).sum()
             val fifthRunner = team.value[4]

             if (score < winner.second || (score == winner.second && fifthRunner < winner.third)) {
                 winner = Triple(team.key, score, fifthRunner)
             }
         }

        println(winner.first)
    }
}