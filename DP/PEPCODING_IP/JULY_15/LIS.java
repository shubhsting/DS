package DP.PEPCODING_IP.JULY_15;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS_BS(nums);
    }

    public int LIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            int current_sub = 1;
            for (int window = 0; window < index; window++) {
                if (nums[window] < nums[index]) {
                    current_sub = Math.max(current_sub, dp[window] + 1);
                }
            }
            dp[index] = current_sub;
            ans = Math.max(ans, dp[index]);
        }
        return ans;
    }

    public int LIS_BS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int window = 1;
        for (int index = 1; index < nums.length; index++) {
            int start = 0;
            int end = window;
            while (start < end) {
                int mid = (start + end) / 2;
                System.out.println(start + "..->" + end);
                if (dp[mid] >= nums[index]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            dp[start] = nums[index];
            if (start == window) {
                window++;
            }
        }
        return window;
    }
}
