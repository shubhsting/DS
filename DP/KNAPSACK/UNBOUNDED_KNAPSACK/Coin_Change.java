package DP.KNAPSACK.UNBOUNDED_KNAPSACK;

// with typical knapsack approach of include exclude.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int ans = coinChange(coins, amount, coins.length, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int coinChange(int[] coins, int amount, int n, int[][] dp) {
        if (amount == 0) {
            return dp[n][amount] = 0;
        }
        if (n == 0) {
            return dp[n][amount] = Integer.MAX_VALUE;
        }
        if (dp[n][amount] != -1) {
            return dp[n][amount];
        }
        int exclude = coinChange(coins, amount, n - 1, dp);
        int include = Integer.MAX_VALUE;
        if (amount >= coins[n - 1]) {
            include = coinChange(coins, amount - coins[n - 1], n, dp);
        }
        if (include != Integer.MAX_VALUE) {
            include += 1;
        }
        return dp[n][amount] = Math.min(include, exclude);
    }
}
