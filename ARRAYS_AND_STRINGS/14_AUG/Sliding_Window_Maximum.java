import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/sliding-window-maximum/description/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] windowPrefixMax = new int[n];
        int[] windowSuffixMax = new int[n];

        windowPrefixMax[0] = nums[0];
        for (int index = 0; index < n; index++) {
            if (index % k == 0) {
                windowPrefixMax[index] = nums[index];
            } else {
                windowPrefixMax[index] = Math.max(nums[index], windowPrefixMax[index - 1]);
            }
        }
        windowSuffixMax[n - 1] = nums[n - 1];
        for (int index = n - 2; index >= 0; index--) {
            if ((index + 1) % k == 0) {
                windowSuffixMax[index] = nums[index];
            } else {
                windowSuffixMax[index] = Math.max(nums[index], windowSuffixMax[index + 1]);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            int endWindow = index + k - 1;
            if (endWindow < n) {
                ans.add(Math.max(windowSuffixMax[index], windowPrefixMax[endWindow]));
            }

        }

        int[] arr = new int[ans.size()];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = ans.get(index);
        }
        return arr;
    }
}
