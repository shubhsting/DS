package DP.LPS;
// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    public String longestPalindrome(String s) {
        return longestPalindromeSubstr_TopDown(s);
    }

    public String longestPalindromeSubstr_TopDown(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        int diagonalDistance = 0;
        int maxLength = 1;
        int start = 0;
        int end = 0;
        while (diagonalDistance < str.length()) {
            for (int row = 0; row < str.length(); row++) {
                int column = row + diagonalDistance;
                if (column >= str.length()) {
                    continue;
                }
                if (diagonalDistance == 0) {
                    dp[row][column] = 1;
                    continue;
                }

                if (str.charAt(row) == str.charAt(column) && (diagonalDistance == 1 || dp[row + 1][column - 1] != 0)) {
                    dp[row][column] = dp[row + 1][column - 1] + 2;
                } else {
                    dp[row][column] = 0;
                }
                start = dp[row][column] > maxLength ? row : start;
                end = dp[row][column] > maxLength ? column : end;
            }
            diagonalDistance++;
        }

        return str.substring(start, end + 1);
    }
}
