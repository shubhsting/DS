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
        if (w == 0 || n == 0) {
            return dp[n][w] = 0;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n - 1] > w) {
            return dp[n][w] = knapsack(w, wt, val, n - 1, dp);
        }

        int include = knapsack(w - wt[n - 1], wt, val, n - 1, dp) + val[n - 1];
        int exclude = knapsack(w, wt, val, n - 1, dp);
        return dp[n][w] = Math.max(include, exclude);
    }
}
