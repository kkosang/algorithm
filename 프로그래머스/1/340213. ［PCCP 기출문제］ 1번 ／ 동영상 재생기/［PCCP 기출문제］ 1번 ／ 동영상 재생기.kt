
class Solution {
    fun solution(
        video_len: String,
        pos: String,
        op_start: String,
        op_end: String,
        commands: Array<String>
    ): String {
        var answer: String = ""
        val videoLen = timeToMinutes(video_len)
        var curPos = timeToMinutes(pos)
        val opStart = timeToMinutes(op_start)
        val opEnd = timeToMinutes(op_end)

     
          
        for (command in commands) {
             if (curPos in opStart..opEnd) {
            curPos = opEnd
        }
            when (command) {
                "next" -> curPos = (curPos + 10).coerceAtMost(videoLen)
                "prev" -> curPos = (curPos - 10).coerceAtLeast(0)
            }
                  if (curPos in opStart..opEnd) {
            curPos = opEnd
        }
        }
        

        return minutesToTime(curPos)
    }

    private fun timeToMinutes(time: String): Int {
        val (hours, minutes) = time.split(":").map { it.toInt() }
        return hours * 60 + minutes
    }

    private fun minutesToTime(minutes: Int): String {
        val hours = minutes / 60
        val mins = minutes % 60
        return "%02d:%02d".format(hours, mins)
    }
}