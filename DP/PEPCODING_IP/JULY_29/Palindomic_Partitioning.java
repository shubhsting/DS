// https://leetcode.com/problems/palindrome-partitioning-ii/
class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return PP(s, 0, dp);
    }

    public int PP(String s, int start, int[] dp) {
        if (isPalindrome(s.substring(start, s.length())))
            return dp[start] = 0;
        if (dp[start] != -1)
            return dp[start];
        int ans = Integer.MAX_VALUE;
        for (int index = start; index < s.length(); index++) {
            if (isPalindrome(s.substring(start, index + 1))) {
                ans = Math.min(ans, 1 + PP(s, index + 1, dp));
            }
        }
        return dp[start] = ans;
    }

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;

    }
}