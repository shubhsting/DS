package DP.LCS;
// https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
class Solution {
    int longestCommonSubstr(String S1, String S2, int n, int m) {
        return LCS_TopDown(S1, S2, n, m);
    }

    public int LCS_TopDown(String text1, String text2, int length1, int length2) {
        int[][] dp = new int[length1 + 1][length2 + 1];
        int ans = 0;
        for (int index1 = 0; index1 <= length1; index1++) {
            for (int index2 = 0; index2 <= length2; index2++) {
                if (index1 == 0 || index2 == 0) {
                    dp[index1][index2] = 0;
                    continue;
                }
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = 0;
                }
                ans = Math.max(dp[index1][index2], ans);
            }
        }
        return ans;
    }
}