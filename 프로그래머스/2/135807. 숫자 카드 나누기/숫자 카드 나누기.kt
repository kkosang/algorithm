class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer: Int = 0
        val gcdA = getGcd(arrayA)
        val gcdB = getGcd(arrayB)
       
       if(!isDivisible(gcdA,arrayB)){
           answer = maxOf(answer,gcdA)
       }
       if(!isDivisible(gcdB,arrayA)){
           answer = maxOf(answer,gcdB)
       }
                
        return answer
    }
    
    fun getGcd(cards:IntArray): Int{
        var result = cards[0]
        for(i in 1 until cards.size){
            result = gcd(result,cards[i])
        }
        return result
    }
    
    fun gcd(a:Int, b:Int): Int {
       return if(b==0) a else gcd(b,a%b)
    }
    
    fun isDivisible(num:Int, arr:IntArray): Boolean {
        return arr.any {it % num == 0}
    }
}