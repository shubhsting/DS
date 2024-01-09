class Solution {
    // https://www.lintcode.com/problem/508/
    /**
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        for (int index = 1; index < nums.length; index += 2) {
            if (nums[index - 1] > nums[index]) {
                int temp = nums[index];
                nums[index] = nums[index - 1];
                nums[index - 1] = temp;
            }
            if (index + 1 < nums.length && nums[index + 1] > nums[index]) {
                int temp = nums[index];
                nums[index] = nums[index + 1];
                nums[index + 1] = temp;
            }
        }
    }
}