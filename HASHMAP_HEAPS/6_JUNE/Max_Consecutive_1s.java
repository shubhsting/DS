//https://leetcode.com/problems/max-consecutive-ones/description/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current_count = 0;
        int ans = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 1) {
                current_count++;
            } else {
                current_count = 0;
            }
            ans = Math.max(current_count, ans);
        }
        return ans;
    }
}