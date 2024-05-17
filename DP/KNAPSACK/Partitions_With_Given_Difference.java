package DP.KNAPSACK;

class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if ((d + sum) % 2 != 0)
            return 0;

        return findWays_TopDown(arr, (d + sum) / 2, n);
    }

    public static int findWays_TopDown(int[] num, int target, int n) {
        int v = 1000000007;
        int[][] dp = new int[n + 1][target + 1];
        for (int noOfElements = 0; noOfElements <= n; noOfElements++) {
            for (int sum = 0; sum <= target; sum++) {
                if (noOfElements == 0) {
                    dp[noOfElements][sum] = sum == 0 ? 1 : 0;
                    continue;
                }

                int exclude = dp[noOfElements - 1][sum];
                int include = 0;
                if (sum >= num[noOfElements - 1])
                    include = dp[noOfElements - 1][sum - num[noOfElements - 1]];
                dp[noOfElements][sum] = (include + exclude) % v;
            }
        }
        return dp[n][target];
    }

}
