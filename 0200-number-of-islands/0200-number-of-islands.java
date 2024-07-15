public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null ) {
            return 0;
        }
        

        int noOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return noOfIslands;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0'; // mark as visited
        
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
}
