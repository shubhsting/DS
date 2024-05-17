package DP.KNAPSACK;
// https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1
class Solution {

    public int minDifference(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // A-B ~ min ==== sum-B-B ~ min ==== sum-2B ~ min
        return subsetSum_TopDown(n, arr, sum);
    }

    static int subsetSum_TopDown(int N, int[] arr, int subset_sum) {
        boolean[][] dp = new boolean[N + 1][subset_sum + 1];
        for (int noOfElements = 0; noOfElements <= N; noOfElements++) {
            for (int sum = 0; sum <= subset_sum; sum++) {
                if (sum == 0) {
                    dp[noOfElements][0] = true;
                    continue;
                } else if (noOfElements == 0) {
                    dp[0][sum] = false;
                    continue;
                } else {
                    if (arr[noOfElements - 1] > sum) {
                        dp[noOfElements][sum] = dp[noOfElements - 1][sum];
                    } else {
                        dp[noOfElements][sum] = dp[noOfElements - 1][sum]
                                || dp[noOfElements - 1][sum - arr[noOfElements - 1]];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int sum = 0; sum <= subset_sum; sum++) {
            if ((subset_sum - 2 * sum) >= 0 && dp[N][sum]) {
                min = Math.min(min, (subset_sum - 2 * sum));
            }
        }
        return min;
    }
}
