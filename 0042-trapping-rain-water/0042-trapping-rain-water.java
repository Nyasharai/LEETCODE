class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(height == null || n == 0){
            return 0;
        }
        
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        
        for(int j = n-2; j >= 0; j--){
            rightMax[j] = Math.max(rightMax[j+1],height[j]);
        }
        
        int trapped = 0;
        for(int p = 0; p < n; p++){
            int waterLevel = Math.min(leftMax[p], rightMax[p]);
            trapped = trapped + waterLevel - height[p];
        }
        
        return trapped;

    }
}