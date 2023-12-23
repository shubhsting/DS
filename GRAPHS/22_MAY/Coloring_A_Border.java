// https://leetcode.com/problems/coloring-a-border/
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        DFS(grid, row, col, grid[row][col], new boolean[grid.length][grid[0].length]);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == -1) {
                    grid[r][c] = color;
                }
            }
        }
        return grid;
    }

    public boolean DFS(int[][] grid, int row, int col, int componentColor, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        if (visited[row][col]) {
            if (grid[row][col] == -1 || grid[row][col] == componentColor) {
                return true;
            }
            return false;
        }
        if (grid[row][col] != componentColor) {
            return false;
        }
        visited[row][col] = true;
        boolean isComponentFoundDown = DFS(grid, row + 1, col, componentColor, visited);
        boolean isComponentFoundUp = DFS(grid, row - 1, col, componentColor, visited);
        boolean isComponentFoundRight = DFS(grid, row, col + 1, componentColor, visited);
        boolean isComponentFoundLeft = DFS(grid, row, col - 1, componentColor, visited);
        if (!isComponentFoundDown || !isComponentFoundUp || !isComponentFoundRight || !isComponentFoundLeft) {
            grid[row][col] = -1;
        }
        return true;
    }
}