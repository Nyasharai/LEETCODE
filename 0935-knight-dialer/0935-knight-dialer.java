class Solution {
    public int knightDialer(int n) {
        int mod = 1000000007;
        int moves[][] = {{4,6}, {6,8}, {7,9}, {8,4}, {9,3,0},{}, {1,7,0}, {6,2}, {3,1}, {2,4}};
        
        int dp[][] = new int[n+1][10];
        
        for(int j = 0; j < 10; j++){
            dp[1][j] = 1;
        }
        
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                for(int move : moves[j]){
                    dp[i][j] = (dp[i][j] + dp[i-1][move]) % mod;
                }
            }
        }
        
        int r = 0;
        for(int i = 0; i < 10; i++){
            r = (r + dp[n][i]) % mod;
        }
        return r;
    }
}