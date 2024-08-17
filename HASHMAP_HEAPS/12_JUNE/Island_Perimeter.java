// https://leetcode.com/problems/island-perimeter/description/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 1)
                    ans = ans + 4 - noOfCornersSurrounded(grid, row, column);
            }
        }
        return ans;
    }

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int noOfCornersSurrounded(int[][] grid, int row, int column) {
        int temp = 0;
        for (int[] direction : directions) {
            int r = row + direction[0];
            int c = column + direction[1];
            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1)
                temp++;
        }
        return temp;
    }
}
