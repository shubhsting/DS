package DP.PEPCODING_IP.JULY_17;

//https://leetcode.com/problems/minimum-path-sum/description/
class Solution {
    int[][] dir = { { -1, 0 }, { 0, -1 } };

    public int minPathSum(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int ans = Integer.MAX_VALUE;
                for (int[] d : dir) {
                    if (row + d[0] >= 0 && col + d[1] >= 0) {
                        ans = Math.min(ans, grid[row + d[0]][col + d[1]]);
                    }
                }
                grid[row][col] = ans == Integer.MAX_VALUE ? grid[row][col] : ans + grid[row][col];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
