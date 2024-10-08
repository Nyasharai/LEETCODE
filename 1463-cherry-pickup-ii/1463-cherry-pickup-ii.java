class Solution {
    int[][][] memo;
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        memo = new int[rows][cols][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return helper(grid, 0, 0, cols - 1);
    }
    private int helper(int[][] grid, int row, int col1, int col2) {
        if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }
        if (memo[row][col1][col2] != -1) {
            return memo[row][col1][col2];
        }
        int count = 0;
        count += grid[row][col1];
        if (col1 != col2) {
            count += grid[row][col2];
        }
        if (row != grid.length - 1) {
            int max = 0;
            for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                    max = Math.max(max, helper(grid, row + 1, newCol1, newCol2));
                }
            }
            count += max;
        }
        return memo[row][col1][col2] = count;
    }
}