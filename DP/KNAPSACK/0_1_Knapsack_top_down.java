package DP.KNAPSACK;

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return knapsack(W, wt, val, n, dp);
    }

    static int knapsack(int w, int[] wt, int[] val, int n, int[][] dp) {

        for (int noOfElements = 0; noOfElements <= n; noOfElements++) {
            for (int weight = 0; weight <= w; weight++) {
                if (noOfElements == 0 || weight == 0) {
                    dp[noOfElements][weight] = 0;
                    continue;
                }
                if (wt[noOfElements - 1] > weight) {
                    dp[noOfElements][weight] = dp[noOfElements - 1][weight];
                } else {
                    dp[noOfElements][weight] = Math.max(dp[noOfElements - 1][weight],
                            dp[noOfElements - 1][weight - wt[noOfElements - 1]] + val[noOfElements - 1]);
                }
            }
        }
        return dp[n][w];
    }
}
