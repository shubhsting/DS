class Solution {
    // https://leetcode.com/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] ans = new int[nums.length];
        int currentIdx = end;
        while (start <= end) {
            int start_square = nums[start] * nums[start];
            int end_square = nums[end] * nums[end];
            if (start_square > end_square) {
                ans[currentIdx] = start_square;
                start++;
            } else {
                ans[currentIdx] = end_square;
                end--;
            }
            currentIdx--;
        }
        return ans;
    }
}
