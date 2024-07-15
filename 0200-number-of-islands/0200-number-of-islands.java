public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;
        
        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') { // Found new island
                    islandCount++;
                    dfs(grid, i, j); // DFS to mark all connected land cells
                }
            }
        }
        
        return islandCount;
    }
    
    // DFS method to mark all connected land cells as visited
    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Base cases for recursion
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }
        
        // Mark current cell as visited
        grid[i][j] = '0';
        
        // DFS on adjacent cells
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
}
