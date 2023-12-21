// https://leetcode.com/problems/number-of-enclaves/
class Solution {
    public int numEnclaves(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
                    DFS(grid, row, col);
                }
            }
        }

        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    count = count + 1;
                }
            }
        }

        return count;
    }

    public void DFS(int[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;

        DFS(grid, row + 1, col);
        DFS(grid, row - 1, col);
        DFS(grid, row, col - 1);
        DFS(grid, row, col + 1);
    }
}