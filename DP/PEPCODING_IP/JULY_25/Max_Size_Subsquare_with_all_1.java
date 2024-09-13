//https://leetcode.com/problems/maximal-square/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                dp[row][column] = matrix[row][column] - '0';
                if (row > 0 && column > 0 && matrix[row][column] == '1') {
                    int square = Math.min(dp[row - 1][column], Math.min(dp[row][column - 1], dp[row - 1][column - 1]));
                    dp[row][column] = square + 1;
                }
                ans = Math.max(dp[row][column], ans);
            }
        }
        return ans * ans;
    }
}