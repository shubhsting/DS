class Solution {
    public int maximumProduct(int[] nums) {
        int max_1 = Integer.MIN_VALUE;
        int max_2 = Integer.MIN_VALUE;
        int max_3 = Integer.MIN_VALUE;
        int min_1 = Integer.MAX_VALUE;
        int min_2 = Integer.MAX_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] <= min_1) {
                min_2 = min_1;
                min_1 = nums[index];
            } else if (nums[index] < min_2) {
                min_2 = nums[index];
            }
            if (nums[index] >= max_1) {
                max_3 = max_2;
                max_2 = max_1;
                max_1 = nums[index];
            } else if (nums[index] >= max_2) {
                max_3 = max_2;
                max_2 = nums[index];
            } else if (nums[index] > max_3) {
                max_3 = nums[index];
            }

        }
        return Math.max(min_1 * min_2 * max_1, max_1 * max_2 * max_3);
    }
}