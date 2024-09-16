// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long currentsum = 0;
        int start = 0;
        int end = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (start < nums.length) {
            if (map.getOrDefault(nums[start], -1) >= end) {
                int new_end = map.get(nums[start]) + 1;
                while (end < new_end) {
                    currentsum -= nums[end];
                    end++;
                }
                continue;
            }
            if (start - end < k) {
                currentsum += nums[start];
                map.put(nums[start], start);
                start++;
            } else {
                map.put(nums[start], start);
                currentsum += nums[start];
                currentsum -= nums[end];
                start++;
                end++;
            }

            if (start - end == k)
                max = Math.max(currentsum, max);
        }
        return max;
    }
}