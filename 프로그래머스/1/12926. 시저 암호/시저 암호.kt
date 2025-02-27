class Solution {
    fun solution(s: String, n: Int): String {
  		var sb = StringBuilder()
        for(i in s.indices){
            when {
                s[i].isLowerCase() -> sb.append('a' + (s[i]-'a'+n) % 26)
                s[i].isUpperCase() -> sb.append('A' + (s[i] -'A'+n)%26)
                else -> sb.append(s[i])
            }
        }
        return sb.toString()
    }   
}