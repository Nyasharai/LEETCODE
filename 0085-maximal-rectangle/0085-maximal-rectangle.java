class Solution {
    public int getMaxArea(int[] heights){
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        int len = heights.length;
        for(int i = 0 ; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(height * width, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int cols = matrix[0].length;
        int heights[] = new int[cols];
        int maxArea = 0;
        
        for(char[] rows : matrix){
            for(int j = 0; j < cols; j++){
                heights[j] = rows[j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, getMaxArea(heights));
        }
        return maxArea;
    }
}

 