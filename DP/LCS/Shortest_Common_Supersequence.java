package DP.LCS;
// https://leetcode.com/problems/shortest-common-supersequence/description/
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return LCS_TopDown(str1, str2);
    }

    public String LCS_TopDown(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int index1 = 1; index1 <= length1; index1++) {
            for (int index2 = 1; index2 <= length2; index2++) {
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        int index1 = text1.length();
        int index2 = text2.length();
        String ans = "";
        while (index1 > 0 && index2 > 0) {
            if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                ans = text1.charAt(index1 - 1) + ans;
                index1--;
                index2--;
            } else {
                if (dp[index1 - 1][index2] > dp[index1][index2 - 1]) {
                    ans = text1.charAt(index1 - 1) + ans;
                    index1--;
                } else {
                    ans = text2.charAt(index2 - 1) + ans;
                    index2--;
                }
            }
        }

        while (index1 > 0) {
            ans = text1.charAt(index1 - 1) + ans;
            index1--;
        }
        while (index2 > 0) {
            ans = text2.charAt(index2 - 1) + ans;
            index2--;
        }
        return ans;
    }
}
