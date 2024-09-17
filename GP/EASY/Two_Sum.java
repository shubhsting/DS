// Time complexity N, space Complexity: n
// https://leetcode.com/problems/two-sum/description/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];
            if (map.containsKey(complement))
                return new int[] { map.get(complement), index };
            map.put(nums[index], index);
        }
        return new int[2];
    }
}
// Time complexity NLogN, space Complexity: 1

class Solution {
    boolean twoSum(int nums[], int target) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] > target)
                end--;
            else if (nums[start] + nums[end] < target)
                start++;
            else
                return true;
        }
        return false;
    }
}