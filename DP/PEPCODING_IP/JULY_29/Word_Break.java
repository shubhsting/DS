//https://leetcode.com/problems/word-break/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        for (String ele : wordDict)
            set.add(ele);
        wordB(s, set, 0, s.length() - 1, dp);
        return dp[0] == 1 ? true : false;
    }

    public boolean wordB(String s, HashSet<String> wordDict, int start, int end, int[] dp) {
        if (wordDict.contains(s.substring(start, end + 1))) {
            dp[start] = 1;
            return true;
        }
        boolean ans = false;
        if (dp[start] != -1)
            return dp[start] == 1 ? true : false;
        for (int index = start; index < end; index++) {
            if (wordDict.contains(s.substring(start, index + 1))) {
                ans = ans || wordB(s, wordDict, index + 1, end, dp);
            }
        }
        dp[start] = ans ? 1 : 0;
        return ans;
    }
}