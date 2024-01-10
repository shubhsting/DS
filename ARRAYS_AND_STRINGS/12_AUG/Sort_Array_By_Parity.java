class Solution {
    // https://leetcode.com/problems/sort-array-by-parity/description/
    public int[] sortArrayByParity(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 0) {
                start++;
            } else if (nums[end] % 2 != 0) {
                end--;
            } else {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
        }
        return nums;
    }
}
