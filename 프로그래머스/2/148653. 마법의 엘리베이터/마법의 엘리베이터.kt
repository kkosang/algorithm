
class Solution {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        var carry = 0
        val number = storey.toString().map { it - '0' }.reversed() // 4 5 5 2
      
        for (i in number.indices) {
            val digit = number[i] + carry
            val down = digit
            val up = 10 - digit

            val nextDigit = if (i + 1 < number.size) number[i + 1] else 0
            
            if (down < up) {
                answer += down
                carry = 0
            } else if (down > up) {
                answer += up
                carry = 1
            } else { // 5 5
                if(nextDigit < 5){ // 현재 내림
                    answer += down
                    carry = 0
                }else{
                    answer += up
                    carry = 1
                }
            }
        }

        if (carry == 1) {
            answer += 1
        }
        
        return answer
    }
}
