class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if((n-1)%(k-1) != 0){
            return -1;
        }
        
        //calculate prefixSum
        int prefix[] = new int[n+1];
        for(int i = 0; i < n; i++){
            prefix[i+1] = prefix[i] + stones[i];
        }
        
        // dp[][][] initialize
        int dp[][][] = new int[n][n][k+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int l = 0; l <= k; l++){
                    dp[i][j][l] = Integer.MAX_VALUE;
                }
            }
        }
        // single pile = 0
        for(int i = 0; i < n; i++){
            dp[i][i][1] = 0;
        }
        
        // dp[][][] fill
        for(int len = 2; len <= n; len++){
            for(int i = 0 ; i <= n - len; i++){
                int j = i + len - 1;
                for(int m = 2; m <= k; m++){
                    for(int mid = i; mid < j; mid++){
                        if(dp[i][mid][m-1] != Integer.MAX_VALUE && dp[mid+1][j][1] != Integer.MAX_VALUE){
                            dp[i][j][m] = Math.min(dp[i][j][m],dp[i][mid][m-1] + dp[mid+1][j][1]);
                        }
                    }
                }
                if(dp[i][j][k] != Integer.MAX_VALUE){
                    dp[i][j][1] = dp[i][j][k] + prefix[j+1] - prefix[i];
                }
            }
        }
        return dp[0][n-1][1];
    }
}