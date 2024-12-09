fun main(){
    val T = readln().toInt()
    repeat(T){
        val n = readln().toInt()
        val stocks = readln().split(" ").map { it.toInt() }
        var maxPrice = 0
        var profit = 0L

        for(i in n-1 downTo 0){
            if(stocks[i] > maxPrice){
                maxPrice = stocks[i]
            }else{
                profit += (maxPrice - stocks[i])
            }
        }

        println(profit)
    }
}