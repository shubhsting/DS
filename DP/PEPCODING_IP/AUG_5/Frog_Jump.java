// https://leetcode.com/problems/frog-jump/
class Solution {
    public boolean canCross(int[] stones) {
        int[][] dp = new int[stones.length][stones.length + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return possible(stones, 0, 0, dp);
    }

    public boolean possible(int[] stones, int currentIdx, int jump, int[][] dp) {
        if (currentIdx >= stones.length - 1) {
            return true;
        }
        boolean ans = false;
        if (dp[currentIdx][jump] != -1)
            return dp[currentIdx][jump] == 1 ? true : false;
        for (int index = currentIdx + 1; index < stones.length; index++) {
            if (stones[currentIdx] + jump == stones[index])
                ans = ans || possible(stones, index, jump, dp);
            if (stones[currentIdx] + jump + 1 == stones[index])
                ans = ans || possible(stones, index, jump + 1, dp);
            if (stones[currentIdx] + jump - 1 == stones[index])
                ans = ans || possible(stones, index, jump - 1, dp);
        }
        dp[currentIdx][jump] = ans ? 1 : 0;
        return ans;
    }
}