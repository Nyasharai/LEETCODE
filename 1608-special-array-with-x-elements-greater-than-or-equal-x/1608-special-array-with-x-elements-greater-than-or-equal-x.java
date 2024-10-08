import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);  // Sort the array
        int s = 0;
        int e = nums.length;
        
        // Perform binary search
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int ans = cnt(nums, mid);
            
            if (ans == mid) {
                return mid;  // Found the special number
            } else if (ans > mid) {
                s = mid + 1;  // Adjust the lower bound
            } else {
                e = mid - 1;  // Adjust the upper bound
            }
        }
        return -1;  // No special number found
    }

    private int cnt(int[] nums, int mid) {
        int count = 0;
        for (int i : nums) {
            if (i >= mid) {
                count++;  // Count elements >= mid
            }
        }
        return count;
    }
}