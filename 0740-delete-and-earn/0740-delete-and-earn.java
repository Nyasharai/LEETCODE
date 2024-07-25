class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int n : nums){
            max = Math.max(n, max);
        }
        
        int point[] = new int[max+1];
        for(int p : nums){
            point[p] += p;
        }
        int dp[] = new int[max+1];
        dp[1] = point[1];
        
        for(int i = 2; i <= max; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + point[i]);
        }
        
        return dp[max];
    }
}