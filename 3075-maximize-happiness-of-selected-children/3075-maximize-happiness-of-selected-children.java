class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long res = 0;
        
        for (int i = n - 1; k > 0; i--) {
            happiness[i] = Math.max(happiness[i] - (n - 1 - i), 0);
            res += happiness[i];
            k--;
        }
        
        return res;
    }
}