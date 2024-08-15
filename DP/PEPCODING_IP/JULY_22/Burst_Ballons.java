package DP.PEPCODING_IP.JULY_22;
// https://leetcode.com/problems/burst-balloons/
class Solution {
    public int maxCoins(int[] nums) {
        // int n =  nums.length;
        // int[] arr = new int[n+2];
        // arr[0] = 1;
        // arr[arr.length - 1] = 1;
        // for(int index = 0; index<nums.length; index++) {
        // arr[index + 1] = nums[index];
        // }
        // int[][] dp = new int[arr.length][arr.length];
        // for(int[] ar: dp) {
        // Arrays.fill(ar, -1);
        // }
        return ballons_topDown(arr);
    }

    public int ballons(int[] arr, int start, int end, int[][] dp) {
        if (start == end) {
            return dp[start][end] = 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int ans = Integer.MIN_VALUE;
        for (int index = start; index < end; index++) {
            int temp = ballons(arr, start, index, dp) + ballons(arr, index + 1, end, dp)
                    + arr[start - 1] * arr[index] * arr[end];
            ans = Math.max(temp, ans);
        }
        return dp[start][end] = ans;
    }

    public int ballons_topDown(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int gap = 1; gap < arr.length; gap++) {
            for (int row = 1; row < arr.length - gap; row++) {
                int column = row + gap;
                int ans = Integer.MIN_VALUE;
                for (int index = row; index < column; index++) {
                    int temp = dp[row][index] + dp[index + 1][column] + arr[row - 1] * arr[index] * arr[column];
                    ans = Math.max(temp, ans);
                }
                dp[row][column] = ans;
            }
        }
        return dp[1][arr.length - 1];
    }
}
