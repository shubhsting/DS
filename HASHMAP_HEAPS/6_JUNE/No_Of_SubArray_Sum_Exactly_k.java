// https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            ps[index] = ps[index - 1] + nums[index];
        }
        HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1);
        int ans = 0;
        for (int index = 0; index < nums.length; index++) {
            int remaining = ps[index] - k;
            if (prefixSumFrequency.containsKey(remaining)) {
                ans += prefixSumFrequency.get(remaining);
            }
            prefixSumFrequency.putIfAbsent(ps[index], 0);
            prefixSumFrequency.put(ps[index], prefixSumFrequency.get(ps[index]) + 1);
        }
        return ans;
    }
}