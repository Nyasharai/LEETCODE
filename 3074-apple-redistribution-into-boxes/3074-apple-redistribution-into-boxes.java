class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int i=0; i<apple.length; i++){
            sum+=apple[i];
        }

        Arrays.sort(capacity);
        int ans = 0;
        for(int i=capacity.length-1; i>=0; i--){
            if(sum<=0) break;
            sum-=capacity[i];
            ans++;
        }
        return ans;
    }
}