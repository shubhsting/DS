// https://leetcode.com/problems/wildcard-matching/description/
class Solution {
    public boolean isMatch(String s, String p) {
        // int[][] dp = new int[s.length()][p.length()];
        // for(int[] d: dp) Arrays.fill(d,-1);
        // return isMatching(s,p,s.length() -1, p.length() -1, dp);
        return topDown(s, p);
    }

    public boolean isMatching(String s, String p, int sIdx, int pIdx, int[][] dp) {
        if (pIdx < 0)
            return sIdx < 0;

        if (sIdx < 0) {
            while (pIdx >= 0) {
                if (p.charAt(pIdx) != '*')
                    return false;
                pIdx--;
            }
            ;
            return true;
        }
        ;
        if (dp[sIdx][pIdx] != -1)
            return dp[sIdx][pIdx] == 1 ? true : false;
        if (p.charAt(pIdx) == '*') {
            boolean ans = false;
            ans = ans || isMatching(s, p, sIdx - 1, pIdx, dp) || isMatching(s, p, sIdx, pIdx - 1, dp);
            dp[sIdx][pIdx] = ans ? 1 : 0;
            return ans;
        } else if (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '?') {
            boolean ans = isMatching(s, p, sIdx - 1, pIdx - 1, dp);
            dp[sIdx][pIdx] = ans ? 1 : 0;
            return ans;
        }
        dp[sIdx][pIdx] = 0;
        return false;
    }

    public boolean topDown(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int row = 0; row <= s.length(); row++) {
            for (int column = 1; column <= p.length(); column++) {
                if (row == 0) {
                    char ch = p.charAt(column - 1);
                    dp[row][column] = (ch == '*' && dp[row][column - 1]) ? true : false;
                    continue;
                }
                if (p.charAt(column - 1) == '*') {
                    dp[row][column] = dp[row - 1][column] || dp[row][column - 1];
                } else if (p.charAt(column - 1) == s.charAt(row - 1) || p.charAt(column - 1) == '?') {
                    dp[row][column] = dp[row - 1][column - 1];
                } else {
                    dp[row][column] = false;
                }

            }
        }
        return dp[s.length()][p.length()];
    }
}