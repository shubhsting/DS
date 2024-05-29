package DP.PEPCODING_IP.JULY_15;
// https://leetcode.com/problems/russian-doll-envelopes/description/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        return LIS_BS(envelopes);
    }

    public int LIS_BS(int[][] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0][1];
        int window = 1;
        for (int index = 1; index < nums.length; index++) {
            int start = 0;
            int end = window;
            while (start < end) {
                int mid = (start + end) / 2;
                if (dp[mid] >= nums[index][1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            dp[start] = nums[index][1];
            if (start == window) {
                window++;
            }
        }
        return window;
    }
}