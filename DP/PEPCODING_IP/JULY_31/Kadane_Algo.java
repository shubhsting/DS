// https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        int currentMax = 0;
        int ans = Integer.MIN_VALUE;
        for (int index = 0; index < arr.length; index++) {
            if (currentMax >= 0)
                currentMax += arr[index];
            else
                currentMax = arr[index];
            ans = Math.max(currentMax, ans);
        }
        return ans;
    }
}
