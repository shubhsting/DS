class Solution {
    // https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // if number> right update the pointer to index+1
        // if number<left last range number ka answer
        // if number >=right && number<=left

        int currentPointer = 0;
        int windowStartPointer = 0;
        int previousRangeAnswer = 0;
        int ans = 0;

        while (currentPointer < nums.length) {
            if (nums[currentPointer] > right) {
                windowStartPointer = currentPointer + 1;
                previousRangeAnswer = 0;
            } else if (nums[currentPointer] < left) {
                ans += previousRangeAnswer;
            } else {
                previousRangeAnswer = currentPointer - windowStartPointer + 1;
                ans += previousRangeAnswer;
            }
            currentPointer++;
        }
        return ans;
    }
}
