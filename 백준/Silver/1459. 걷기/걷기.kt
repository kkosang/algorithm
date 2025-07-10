import kotlin.math.*
import java.util.*
import java.io.*

fun main() {
    val (x,y,w,s) = readln().split(" ").map {it.toLong()}
    
    val min = minOf(x,y)
    val max = maxOf(x,y)
    val diff = max-min
    
    val answer = when {
        // case 1, 대각선이 비싸 직선만 사용하는 경우
        s >= w * 2 -> (x+y)*w
        
        // case 2, 대각선이 직선보다 저렴하여 대각선 활용
        s <= w -> {
            if((x+y)%2 == 0L){
                max*s
            }
            else{
                (max-1)*s +w
            }
        }
        
        // case 3, 복합사용
        else -> {
            min * s + diff * w
        }
    }
    println(answer)
    
}