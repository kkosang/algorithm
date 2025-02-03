import java.util.LinkedList
import java.util.Queue

class Solution {
    val dy = intArrayOf(-1,0,1,0)
    val dx = intArrayOf(0,1,0,-1)

    fun solution(maps: Array<String>): IntArray {
        val visited = Array(maps.size) { BooleanArray(maps[0].length) }
        val result = mutableListOf<Int>()

        for(x in maps.indices){
            for(y in maps[x].indices){
                if(!visited[x][y] && maps[x][y] != 'X'){
                    result.add(bfs(x to y, maps,visited))
                }
            }
        }

        return if (result.isEmpty()) intArrayOf(-1) else result.sorted().toIntArray()
    }

    fun bfs(start:Pair<Int,Int>,maps:Array<String>, visited: Array<BooleanArray>) : Int{
        val q : Queue<Pair<Int, Int>> = LinkedList()
        q.add(Pair(start.first,start.second))
        visited[start.first][start.second] = true
        var sum = maps[start.first][start.second] - '0'

        while(q.isNotEmpty()){
            val (x,y) = q.poll()!!

            for(idx in 0 until 4){
                val nx = x + dx[idx]
                val ny = y + dy[idx]

                if(nx in maps.indices && ny in maps[0].indices
                    && maps[nx][ny] != 'X' && !visited[nx][ny]){
                    q.add(Pair(nx,ny))
                    visited[nx][ny] = true
                    sum += maps[nx][ny]-'0'
                }

            }
        }

        return sum
    }
}