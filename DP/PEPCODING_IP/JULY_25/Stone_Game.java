//https://leetcode.com/problems/stone-game/description/
class Solution {
    public boolean stoneGame(int[] nums) {
        long total = 0;
        for (int num : nums)
            total += num;
        long[][] dp = new long[nums.length][nums.length];
        for (long[] d : dp)
            Arrays.fill(d, -1);
        long myAns = maxPossibleScore(nums, 0, nums.length - 1, dp);
        return myAns >= (total - myAns);
    }

    public long maxPossibleScore(int[] nums, int start, int end, long[][] dp) {
        if (start == end)
            return dp[start][end] = nums[start];
        if (start > end)
            return 0;
        if (dp[start][end] != -1)
            return dp[start][end];
        long chooseStart = Math.min(maxPossibleScore(nums, start + 1, end - 1, dp),
                maxPossibleScore(nums, start + 2, end, dp)) + nums[start];
        long chooseEnd = Math.min(maxPossibleScore(nums, start + 1, end - 1, dp),
                maxPossibleScore(nums, start, end - 2, dp)) + nums[end];
        return dp[start][end] = Math.max(chooseStart, chooseEnd);
    }
}