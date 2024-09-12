// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
class Solution {
    public int minimumMountainRemovals(int[] nums) {

        int[] lisBack = LIS_BACK(nums);
        int longestBitonic = 1;
        int[] lis = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currentMaxLength = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    currentMaxLength = Math.max(currentMaxLength, lis[j] + 1);
            }
            lis[i] = currentMaxLength;
        }

        for (int i = 0; i < nums.length; i++) {
            if (lis[i] > 1 && lisBack[i] > 1)
                longestBitonic = Math.max(longestBitonic, lis[i] + lisBack[i] - 1);
        }
        return nums.length - longestBitonic;
    }

    public int[] LIS_BACK(int[] nums) {
        int[] lis = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int currentMaxLength = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    currentMaxLength = Math.max(currentMaxLength, lis[j] + 1);
            }
            lis[i] = currentMaxLength;
        }
        return lis;
    }
}