import kotlin.math.pow

class Solution {
    fun solution(n: Int): Int {
        val three = makeThree(n)
        val answer = toDecimal(three)
        return answer
    }
    
    fun makeThree(n:Int) : String {
        var three = ""
        var num = n
        while(num > 0){
            three += (num%3)
            num = num/3 
        }
        return three
    }
    
    fun toDecimal(three:String) : Int{
        var decimal = 0
        val len = three.length-1
        
        for(i in three.indices){
            val digit = three[i] - '0'
            decimal += digit * Math.pow(3.0, (len-i).toDouble()).toInt()
        }
        
        return decimal
    }
}