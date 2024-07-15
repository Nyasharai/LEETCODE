class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Check for edge cases
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        
        int originalColor = image[sr][sc];
        
        // Only perform flood fill if the new color is different from the original color
        if (originalColor != newColor) {
            dfs(image, sr, sc, originalColor, newColor);
        }
        
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        // Check boundaries and whether the current pixel matches the original color
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originalColor) {
            return;
        }
        
        // Change the current pixel color to the new color
        image[sr][sc] = newColor;
        
        // Recursively flood fill in 4 directions
        dfs(image, sr + 1, sc, originalColor, newColor); // down
        dfs(image, sr - 1, sc, originalColor, newColor); // up
        dfs(image, sr, sc + 1, originalColor, newColor); // right
        dfs(image, sr, sc - 1, originalColor, newColor); // left
    }
}
