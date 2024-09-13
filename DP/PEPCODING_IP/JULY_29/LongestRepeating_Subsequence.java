// https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
class Solution {
    public int LongestRepeatingSubsequence(String str) {
        return LCS_TopDown(str, str);
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
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1) && index1 != index2) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }
        return dp[length1][length2];
    }

}
