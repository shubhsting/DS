// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    public int findMin(int[] nums) {
        int idx = getRotatedIndex(nums);
        System.out.println(idx);
        return idx + 1 < nums.length ? Math.min(nums[idx], nums[idx + 1]) : Math.min(nums[idx], nums[0]);
    }

    public int getRotatedIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int idx = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}