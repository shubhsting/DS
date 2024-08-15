package DP.PEPCODING_IP.JULY_24;
// https://leetcode.com/problems/longest-common-subsequence/description/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] dp = new int[text1.length()+1][text2.length()+1];
        // for(int[] row: dp) {
        // Arrays.fill(row, -1);
        // }
        // return LCS_Memoised(text1, text2, text1.length(), text2.length(), dp);
        return LCS_TopDown(text1, text2);
    }

    public int LCS_recursive(String text1, String text2, int index1, int index2) {
        if (index1 == 0 || index2 == 0) {
            return 0;
        }
        if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
            return 1 + LCS_recursive(text1, text2, index1 - 1, index2 - 1);
        }
        return Math.max(LCS_recursive(text1, text2, index1, index2 - 1),
                LCS_recursive(text1, text2, index1 - 1, index2));
    }

    public int LCS_Memoised(String text1, String text2, int index1, int index2, int[][] dp) {
        if (index1 == 0 || index2 == 0) {
            return dp[index1][index2] = 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
            return dp[index1][index2] = 1 + LCS_Memoised(text1, text2, index1 - 1, index2 - 1, dp);
        }
        return dp[index1][index2] = Math.max(LCS_Memoised(text1, text2, index1, index2 - 1, dp),
                LCS_Memoised(text1, text2, index1 - 1, index2, dp));
    }

    public int LCS_TopDown(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int index1 = 0; index1 <= length1; index1++) {
            for (int index2 = 0; index2 <= length2; index2++) {
                if (index1 == 0 || index2 == 0) {
                    dp[index1][index2] = 0;
                    continue;
                }
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
