// https://leetcode.com/problems/distinct-subsequences/description/
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return nd(s, t);
    }

    public int nd(String s, String t, int sIdx, int tIdx, int[][] dp) {
        if (tIdx >= t.length())
            return 1;
        if (sIdx >= s.length())
            return 0;
        if (dp[sIdx][tIdx] != -1)
            return dp[sIdx][tIdx];
        int ans = 0;
        if (s.charAt(sIdx) == t.charAt(tIdx))
            ans += nd(s, t, sIdx + 1, tIdx + 1, dp);

        ans += nd(s, t, sIdx + 1, tIdx, dp);
        return dp[sIdx][tIdx] = ans;
    }

    public int nd(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;

        for (int row = 0; row <= s.length(); row++) {
            for (int column = 0; column <= t.length(); column++) {
                if (column == 0) {
                    dp[row][column] = 1;
                    continue;
                }
                if (row == 0) {
                    dp[row][column] = 0;
                    continue;
                }
                if (s.charAt(row - 1) == t.charAt(column - 1))
                    dp[row][column] += dp[row - 1][column - 1];
                dp[row][column] += dp[row - 1][column];
            }
        }
        return dp[s.length()][t.length()];
    }
}
