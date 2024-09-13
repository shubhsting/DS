// https://leetcode.com/problems/edit-distance/
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0 || m == 0)
            return n == 0 ? m : n;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        minDistance1(word1, word2, n - 1, m - 1, dp);
        return dp[n - 1][m - 1];
    }

    public int minDistance1(String word1, String word2, int idx1, int idx2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0)
            return idx1 < 0 ? idx2 + 1 : idx1 + 1;
        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];
        if (word1.charAt(idx1) == word2.charAt(idx2))
            return dp[idx1][idx2] = minDistance1(word1, word2, idx1 - 1, idx2 - 1, dp);
        return dp[idx1][idx2] = 1 + Math.min(minDistance1(word1, word2, idx1 - 1, idx2 - 1, dp), Math
                .min(minDistance1(word1, word2, idx1 - 1, idx2, dp), minDistance1(word1, word2, idx1, idx2 - 1, dp)));
    }
}
