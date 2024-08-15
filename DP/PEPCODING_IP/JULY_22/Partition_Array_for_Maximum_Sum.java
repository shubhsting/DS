package DP.PEPCODING_IP.JULY_22;
// https://leetcode.com/problems/partition-array-for-maximum-sum/description/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        return MCM_memoised(arr, k, 0, arr.length, dp);
    }

    public int MCM(int[] arr, int k, int start, int end) {
        System.out.println(start + "," + end);
        if (start == end) {
            return 0;
        }
        int max = 0;
        int ans = Integer.MIN_VALUE;
        for (int index = 0; index < k; index++) {
            if (start + index < end) {
                max = Math.max(max, arr[start + index]);
                int temp = MCM(arr, k, start + index + 1, end) + ((index + 1) * max);
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }

    public int MCM_memoised(int[] arr, int k, int start, int end, int[][] dp) {
        if (start == end) {
            return dp[start][end] = 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int max = 0;
        int ans = Integer.MIN_VALUE;
        for (int index = 0; index < k; index++) {
            if (start + index < end) {
                max = Math.max(max, arr[start + index]);
                int temp = MCM_memoised(arr, k, start + index + 1, end, dp) + ((index + 1) * max);
                ans = Math.max(temp, ans);
            }
        }
        return dp[start][end] = ans;
    }
}
