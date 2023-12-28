class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i = 0 ; i<nums.length-2;i++){
            for(int j =i+1; j<nums.length-1;j++){
                for(int k=j+1; k<nums.length;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    boolean prime = true;
                   for(int r=2; r<sum; r++){
                       if(sum%r == 0){
                           prime = false;
                           break;
                       }
                   }
                    if(prime)
                        answer++;
                }
            }
        }
        
        return answer;
    }
}