// https://leetcode.com/problems/predict-the-winner/
class Solution {
    public boolean predictTheWinner(int[] nums) {
        long total = 0;
        for (int num : nums)
            total += num;
        long myAns = maxPossibleScore(nums, 0, nums.length - 1);
        return myAns >= (total - myAns);
    }

    public long maxPossibleScore(int[] nums, int start, int end) {
        if (start == end)
            return nums[start];
        if (start > end)
            return 0;
        long chooseStart = Math.min(maxPossibleScore(nums, start + 1, end - 1), maxPossibleScore(nums, start + 2, end))
                + nums[start];
        long chooseEnd = Math.min(maxPossibleScore(nums, start + 1, end - 1), maxPossibleScore(nums, start, end - 2))
                + nums[end];
        return Math.max(chooseStart, chooseEnd);
    }
}