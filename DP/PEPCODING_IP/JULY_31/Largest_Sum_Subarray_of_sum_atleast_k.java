class Solution {
// https://www.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k3121/1
    public long maxSumWithK(long arr[], long n, long k) {
        long[] maxSubarraySum = new long[arr.length];

        long currentSum = 0;
        for (int index = 0; index < n; index++) {
            if (currentSum >= 0)
                currentSum += arr[index];
            else
                currentSum = arr[index];
            maxSubarraySum[index] = currentSum;
        }

        int start = 0;
        int end = 0;
        long ans = Integer.MIN_VALUE;
        long currentWindowSum = 0;
        while (end < n) {
            if (end - start < k) {
                currentWindowSum += arr[end];
                end++;
            } else {
                currentWindowSum += arr[end];
                currentWindowSum -= arr[start];
                start++;
                end++;
            }
            if (end - start == k) {
                long val1 = Integer.MIN_VALUE;
                if (start - 1 >= 0)
                    val1 = currentWindowSum + maxSubarraySum[start - 1];
                long val2 = Math.max(currentWindowSum, val1);
                ans = Math.max(ans, val2);
            }
        }
        return ans;
    }

}