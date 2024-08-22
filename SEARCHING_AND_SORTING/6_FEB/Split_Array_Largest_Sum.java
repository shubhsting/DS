// https://leetcode.com/problems/split-array-largest-sum/description/
class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isCapacityWithinKSubarrays(mid, k, nums)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isCapacityWithinKSubarrays(int sum, int k, int[] nums) {
        int currentSum = 0;
        int noOfSubarrays = 1;
        for (int num : nums) {
            if (currentSum + num <= sum) {
                currentSum += num;
            } else {
                currentSum = num;
                noOfSubarrays++;
            }
        }
        return noOfSubarrays <= k;
    }
}
