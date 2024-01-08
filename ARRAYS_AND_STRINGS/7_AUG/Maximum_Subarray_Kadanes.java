class Solution {
    // https://leetcode.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int current_max = 0;
        int overall_max = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (current_max >= 0) {
                current_max += nums[index];
            } else {
                current_max = nums[index];
            }
            overall_max = Math.max(overall_max, current_max);
        }
        return overall_max;
    }
}
