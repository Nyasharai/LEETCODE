class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // Arrays to store the maximum and minimum products up to each index
        int[] maxDP = new int[n];
        int[] minDP = new int[n];
        
        // Initialize the first value for both arrays
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        
        // Initialize the result with the first element
        int result = nums[0];

        // Iterate through the array, updating the max and min products at each step
        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                maxDP[i] = Math.max(nums[i], maxDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], minDP[i - 1] * nums[i]);
            } else {
                maxDP[i] = Math.max(nums[i], minDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], maxDP[i - 1] * nums[i]);
            }
            // Update the result with the maximum value found so far
            result = Math.max(result, maxDP[i]);
        }

        return result;
    
    }
}