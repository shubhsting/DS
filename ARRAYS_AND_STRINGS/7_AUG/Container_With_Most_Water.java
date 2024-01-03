class Solution {
    // https://leetcode.com/problems/container-with-most-water/description/
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (start < end) {
            int water_covered = (end - start) * Math.min(height[start], height[end]);
            ans = Math.max(ans, water_covered);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return ans;
    }
}