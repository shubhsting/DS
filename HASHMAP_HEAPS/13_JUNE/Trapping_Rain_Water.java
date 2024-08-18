//https://leetcode.com/problems/trapping-rain-water/description/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = height[0];
        for (int index = 1; index < n; index++) {
            left_max[index] = Math.max(left_max[index - 1], height[index]);
        }

        right_max[n - 1] = height[n - 1];
        for (int index = n - 2; index >= 0; index--) {
            right_max[index] = Math.max(right_max[index + 1], height[index]);
        }
        int ans = 0;
        for (int index = 1; index < n - 1; index++) {
            int neighbour = Math.min(left_max[index - 1], right_max[index + 1]);
            ans = neighbour - height[index] > 0 ? ans + (neighbour - height[index]) : ans;
        }
        return ans;
    }
}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int start = 1;
        int end = n - 1;
        int left_max = height[0];
        int right_max = height[n - 1];
        int ans = 0;
        while (start <= end) {
            if (left_max <= right_max) {
                ans = left_max - height[start] > 0 ? ans + left_max - height[start] : ans;
                left_max = Math.max(left_max, height[start]);
                start++;
            } else {
                ans = right_max - height[end] > 0 ? ans + right_max - height[end] : ans;
                right_max = Math.max(right_max, height[end]);
                end--;
            }
        }
        return ans;
    }
}