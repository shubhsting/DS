class Solution {
    public int dominantIndex(int[] nums) {
        int max_1 = Integer.MIN_VALUE;
        int max_2 = Integer.MIN_VALUE;
        int ans = -1;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] >= max_1) {
                max_2 = max_1;
                max_1 = nums[index];
                ans = index;
            } else if (nums[index] > max_2) {
                max_2 = nums[index];
            }
        }
        return max_1 >= 2 * max_2 ? ans : -1;
    }
}
