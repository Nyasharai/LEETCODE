class Solution {
    public int superEggDrop(int k, int n) {
//         int dp[][] = new int[k+1][n+1];
        
//         for(int i = 1; i <= n; i++){
//             dp[1][i] = i;
//         }
        
//         for(int j = 1; j <=k; j++){
//             dp[j][1] = 1;
//         }
        
//         for(int i = 2; i <= k; i++){
//             for(int j = 2; j <= n; j++){
//                 dp[i][j] = Integer.MAX_VALUE;
//                 for(int x =1; x <= j; x++){
//                     dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i-1][x-1], dp[i][j - x]));
//                 }
//             }
//         }
//         return dp[k][n];
        
        int dp[][] = new int[k+1][n+1];
        int m = 0;
        
        while(dp[k][m] < n){
            ++m;
            
            for(int i = 1; i <= k; i++){
                dp[i][m] = 1 + dp[i-1][m-1] + dp[i][m-1];
            }
        }
        return m;
    }
}