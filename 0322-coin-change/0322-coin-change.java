class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]= 0;
        // for(int i = 0; i < n+1; i++){
        //     dp[i][0] = 1;
        // }
        // for(int j = 0; j < sum+1; j++){
        //     dp[0][j] = 0;
        // }
        
        for(int i = 1; i < amount+1; i++){
            for(int j = 0; j < n; j++){
            if(coins[j] <= i){
                dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}