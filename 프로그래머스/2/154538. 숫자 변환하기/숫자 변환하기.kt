import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = 0
        
        val q : Queue<Pair<Int,Int>> = LinkedList()
        val visited = BooleanArray(y+1){false}
        q.add(x to 0)
        visited[x] = true
        
        while(q.isNotEmpty()){
            val (cur,cnt) = q.poll()
            
            if(cur == y) return cnt
            
            val next = listOf(cur+n,cur*2,cur*3)
            for(n in next){
                if(n <= y && !visited[n]) {
                    q.add(n to cnt+1)
                    visited[n] = true
                }
            }
        }
       
        return -1
    }
}
