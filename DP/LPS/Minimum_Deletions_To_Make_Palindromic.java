package DP.LPS;

class Solution {
    int minDeletions(String str, int n) {
        int length = longestPalindromeSubseq_TopDown(str);
        return n - length;
    }

    public int longestPalindromeSubseq_TopDown(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        int diagonalDistance = 0;
        while (diagonalDistance < str.length()) {
            for (int row = 0; row < str.length(); row++) {
                int column = row + diagonalDistance;
                if (column >= str.length()) {
                    continue;
                }
                if (row == column) {
                    dp[row][column] = 1;
                    continue;
                }

                if (str.charAt(row) == str.charAt(column)) {
                    dp[row][column] = dp[row + 1][column - 1] + 2;
                } else {
                    dp[row][column] = Math.max(dp[row + 1][column], dp[row][column - 1]);
                }
            }
            diagonalDistance++;
        }

        return dp[0][str.length() - 1];
    }
}
