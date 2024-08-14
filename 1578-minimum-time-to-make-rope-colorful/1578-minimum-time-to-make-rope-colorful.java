class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total = 0;
        int n = neededTime.length;
        
        for(int i = 0; i < n; i++){
            if(i > 0 && colors.charAt(i) == colors.charAt(i - 1)){
                total += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return total;
    }
}