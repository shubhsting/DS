// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isSumOfDivisorLimit(mid, nums, threshold)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isSumOfDivisorLimit(int divisor, int[] nums, int threshold) {
        int divisorSum = 0;
        for (int num : nums) {
            divisorSum += (int) Math.ceil((double) num / divisor);
        }
        return divisorSum <= threshold;
    }
}