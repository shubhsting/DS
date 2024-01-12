class Solution {
    // https://leetcode.com/problems/partition-array-into-disjoint-intervals/description/
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int maxTillNow = Integer.MIN_VALUE;
        int currentLeftEnd = 0;
        int currentIdx = 0;
        while (currentIdx < nums.length) {
            if (nums[currentIdx] < leftMax) {
                currentLeftEnd = currentIdx;
                leftMax = maxTillNow;
            }
            maxTillNow = Math.max(maxTillNow, nums[currentIdx]);
            currentIdx++;
        }
        return currentLeftEnd - 0 + 1;
    }
}
