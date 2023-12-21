// https://leetcode.com/problems/number-of-islands
class Solution {
    public int numIslands(char[][] grid) {
        int noOfIsland = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    noOfIsland = noOfIsland + 1;
                    DFS(grid, row, col);
                }
            }
        }
        return noOfIsland;
    }

    public void DFS(char[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        DFS(grid, row + 1, col);
        DFS(grid, row - 1, col);
        DFS(grid, row, col - 1);
        DFS(grid, row, col + 1);
    }
}