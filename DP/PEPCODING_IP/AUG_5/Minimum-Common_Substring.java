//https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int ans = 0;
        for (int row = 1; row <= str1.length(); row++) {
            for (int column = 1; column <= str2.length(); column++) {
                if (str1.charAt(row - 1) == str2.charAt(column - 1)) {
                    dp[row][column] = dp[row - 1][column - 1] + 1;
                } else {
                    dp[row][column] = 0;
                }
                ans = Math.max(ans, dp[row][column]);
            }
        }
        return ans;
    }
}