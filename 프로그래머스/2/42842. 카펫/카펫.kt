class Solution {
    // brown = 2 * (width + height -2)
    fun solution(brown: Int, yellow: Int): IntArray {
        val total = brown + yellow
        
        for(width in total downTo 1){
            if(total % width == 0){
                val height = total / width
                if(brown == 2*(width + height -2)){
                    return intArrayOf(width,height)
                }
            }
        }
   
        return intArrayOf()
    }
}