//https://leetcode.com/problems/regular-expression-matching/
class Solution {
    public boolean isMatch(String s, String p) {
        return topDown(s, p);
        // return shouldMatch(s,p,s.length()-1,p.length()-1);
    }

    public boolean shouldMatch(String s, String p, int sIdx, int pIdx) {
        if (pIdx < 0)
            return sIdx < 0;
        if (sIdx < 0)
            return p.charAt(pIdx) == '*' && pIdx - 2 < 0;
        if (p.charAt(pIdx) == '*') {
            if (s.charAt(sIdx) == p.charAt(pIdx - 1) || p.charAt(pIdx - 1) == '.')
                return shouldMatch(s, p, sIdx - 1, pIdx) || shouldMatch(s, p, sIdx, pIdx - 1)
                        || shouldMatch(s, p, sIdx, pIdx - 2);
            return shouldMatch(s, p, sIdx, pIdx - 2);
        } else {
            if (p.charAt(pIdx) == '.' || p.charAt(pIdx) == s.charAt(sIdx))
                return shouldMatch(s, p, sIdx - 1, pIdx - 1);
            else
                return false;
        }
    }

    public boolean topDown(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int row = 0; row <= s.length(); row++) {
            for (int column = 1; column <= p.length(); column++) {
                if (row == 0) {
                    char ch = p.charAt(column - 1);
                    dp[row][column] = (ch == '*' && (dp[row][column - 1] || dp[row][column - 2])) ? true : false;
                    continue;
                }
                if (p.charAt(column - 1) == '*') {
                    if (p.charAt(column - 2) == s.charAt(row - 1) || p.charAt(column - 2) == '.')
                        dp[row][column] = dp[row - 1][column] || dp[row][column - 1] || dp[row][column - 2];
                    else
                        dp[row][column] = dp[row][column - 2];
                } else if (p.charAt(column - 1) == s.charAt(row - 1) || p.charAt(column - 1) == '.') {
                    dp[row][column] = dp[row - 1][column - 1];
                } else {
                    dp[row][column] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}