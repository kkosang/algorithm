class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n>=a){
            int cnt= 0;
            for(int i = a; i<=n; i+=a){
                cnt++;
            }
            n = n - a*cnt + b*cnt;
            answer = answer+ b*cnt;
        }
      
        
        return answer;
    }
}