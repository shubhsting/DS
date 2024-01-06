class Solution {
    //https://leetcode.com/problems/product-of-array-except-self/description/
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            ans[index] = nums[index] * ans[index - 1];
        }

        int suffixMultiplication = 1;
        for (int index = nums.length - 1; index > 0; index--) {
            ans[index] = ans[index - 1] * suffixMultiplication;
            suffixMultiplication = suffixMultiplication * nums[index];
        }
        ans[0] = suffixMultiplication;
        return ans;
    }
}