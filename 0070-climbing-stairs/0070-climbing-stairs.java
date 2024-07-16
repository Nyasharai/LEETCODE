// class Solution {
//     public int climbStairs(int n) {
//         if(n == 0){
//             return 1;
//         }
//         if(n < 0){
//             return 0;
//         }
        
//         int dp[] = new int[n+1];
//         dp[0] = 1;
//         dp[1] = 1;
//         for(int i = 2; i <= n; i++){
//             dp[i] = climbStairs(i-1) + climbStairs(i-2);
//         }
       
//         return dp[n];
        
//     }
// }

class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int first = 1; // Represents dp[0]
        int second = 1; // Represents dp[1]

        for (int i = 2; i <= n; i++) {
            int third = first + second; // Represents dp[i]
            first = second; // Move first to the next position
            second = third; // Move second to the next position
        }

        return second; // The result for dp[n]
    }
}
