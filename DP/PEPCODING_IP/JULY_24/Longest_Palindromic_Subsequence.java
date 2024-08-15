package DP.PEPCODING_IP.JULY_24;
// https://leetcode.com/problems/longest-palindromic-subsequence/
class Solution {
    public int longestPalindromeSubseq(String s) {
        // int[][] dp = new int[s.length()][s.length()];
        // for(int[] ar: dp) {
        // Arrays.fill(ar, -1);
        // }
        return longestPalindromeSubseq_TopDown(s);
    }

    public int longestPalindromeSubseq_Rec(String str, int start, int end) {
        if (start == end) {
            return 1;
        }
        if (end < start)
            return 0;
        if (str.charAt(start) == str.charAt(end)) {
            return longestPalindromeSubseq_Rec(str, start + 1, end - 1) + 2;
        }
        return Math.max(longestPalindromeSubseq_Rec(str, start + 1, end),
                longestPalindromeSubseq_Rec(str, start, end - 1));
    }

    public int longestPalindromeSubseq_Memoised(String str, int start, int end, int[][] dp) {
        if (start == end) {
            return dp[start][end] = 1;
        }
        if (end < start)
            return dp[start][end] = 0;
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (str.charAt(start) == str.charAt(end)) {
            return dp[start][end] = longestPalindromeSubseq_Memoised(str, start + 1, end - 1, dp) + 2;
        }
        return dp[start][end] = Math.max(longestPalindromeSubseq_Memoised(str, start + 1, end, dp),
                longestPalindromeSubseq_Memoised(str, start, end - 1, dp));
    }

    public int longestPalindromeSubseq_TopDown(String str) {
        int n = str.length();
        int[][] dp = new int[str.length()][str.length()];
        for (int gap = 0; gap < n; gap++) {
            for (int row = 0; row < n - gap; row++) {
                int column = row + gap;
                if (gap == 0) {
                    dp[row][column] = 1;
                    continue;
                }

                if (str.charAt(row) == str.charAt(column)) {
                    dp[row][column] = 2 + dp[row + 1][column - 1];
                } else {
                    dp[row][column] = Math.max(dp[row + 1][column], dp[row][column - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}