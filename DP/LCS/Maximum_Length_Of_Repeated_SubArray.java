package DP.LCS;
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        return LCS_TopDown(nums1, nums2, nums1.length, nums2.length);
    }

    public int LCS_TopDown(int[] nums1, int[] nums2, int length1, int length2) {
        int[][] dp = new int[length1 + 1][length2 + 1];
        int ans = 0;
        for (int index1 = 0; index1 <= length1; index1++) {
            for (int index2 = 0; index2 <= length2; index2++) {
                if (index1 == 0 || index2 == 0) {
                    dp[index1][index2] = 0;
                    continue;
                }
                if (nums1[index1 - 1] == nums2[index2 - 1]) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = 0;
                }
                ans = Math.max(dp[index1][index2], ans);
            }
        }
        return ans;
    }
}
