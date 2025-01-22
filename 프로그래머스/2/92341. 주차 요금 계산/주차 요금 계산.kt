import kotlin.math.ceil

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val parkingRecords = mutableMapOf<String, MutableList<String>>()
        for (record in records) {
            val (time, car, state) = record.split(" ")
            parkingRecords.putIfAbsent(car, mutableListOf())
            parkingRecords[car]?.add(time)
        }

        val parkingTimes = mutableMapOf<String, Int>()
        for ((car, times) in parkingRecords) {
            var time = 0
            val timeList = if (times.size % 2 == 0) times else times + "23:59"

            for (i in timeList.indices step 2) {
                time += minutes(timeList[i], timeList[i + 1])
            }
            parkingTimes[car] = time
        }

        parkingTimes.map { (car, time) ->
            car to parkingFee(fees, time)
        }.sortedBy { it.first }.forEach {
            answer += it.second
        }

        return answer
    }

    private fun minutes(inTime: String, outTime: String): Int {
        val (inHour, inMinute) = inTime.split(":").map { it.toInt() }
        val (outHour, outMinute) = outTime.split(":").map { it.toInt() }
        return (outHour - inHour) * 60 + (outMinute - inMinute)
    }

    private fun parkingFee(fees: IntArray, minutes: Int): Int {
        val (baseTime, baseFee, perTime, perFee) = fees
        return if (minutes <= baseTime) {
            baseFee
        } else {
            baseFee + ceil((minutes - baseTime) / perTime.toDouble()).toInt() * perFee
        }
    }
}
