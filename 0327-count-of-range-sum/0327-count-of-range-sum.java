import java.util.*;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        // Sort and process range sums
        return countRangeSum(prefixSum, lower, upper);
    }
    
    private int countRangeSum(long[] prefixSum, int lower, int upper) {
        int n = prefixSum.length;
        int count = 0;
        List<Long> sortedPrefixSum = new ArrayList<>();
        
        for (long ps : prefixSum) {
            // Count the number of valid range sums using binary search
            int countLower = countLessEqual(sortedPrefixSum, ps - lower);
            int countUpper = countLessEqual(sortedPrefixSum, ps - upper - 1);
            count += countLower - countUpper;
            
            // Insert current prefix sum into the sorted list
            insertSorted(sortedPrefixSum, ps);
        }
        
        return count;
    }
    
    // Count how many numbers in sortedPrefixSum are <= target
    private int countLessEqual(List<Long> sortedPrefixSum, long target) {
        int low = 0, high = sortedPrefixSum.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (sortedPrefixSum.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    // Insert a number into the sorted list while maintaining sorted order
    private void insertSorted(List<Long> sortedPrefixSum, long value) {
        int low = 0, high = sortedPrefixSum.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (sortedPrefixSum.get(mid) < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        sortedPrefixSum.add(low, value);
    }
}
