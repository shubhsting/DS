class Solution {

    // https://leetcode.com/problems/majority-element/submissions/
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 1;

        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == element) {
                count++;
            } else {
                if (count == 0) {
                    element = nums[index];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == element) {
                count++;
            }
        }
        return count > nums.length / 2 ? element : -1;
    }
}