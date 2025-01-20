
class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val reports = report.map { it.split(" ") }.distinct()
        val reportedCounts = mutableMapOf<String, Int>()
        
        reports.forEach { (_, reported) ->
            reportedCounts[reported] = reportedCounts.getOrDefault(reported, 0) + 1
        }

        val bannedUsers = reportedCounts.filter { it.value >= k }.keys

        val mailCounts = mutableMapOf<String, Int>()
        
        reports.forEach { (reporter, reported) ->
            if (reported in bannedUsers) {
                mailCounts[reporter] = mailCounts.getOrDefault(reporter, 0) + 1
            }
        }

        return id_list.map { mailCounts.getOrDefault(it, 0) }.toIntArray()
    }
}
