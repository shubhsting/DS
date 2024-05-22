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

// with typical coin change approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        // int[] dp= new int[amount+1];
        // Arrays.fill(dp, -1);
        int ans = coinChange_TopDown(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int coinChange_Memoised(int[] coins, int amount, int n, int[] dp) {
        if (amount == 0) {
            return dp[0] = 0;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }

        int ans = Integer.MAX_VALUE;
        for (int index = 0; index < coins.length; index++) {
            if (coins[index] <= amount) {
                int coinCount = coinChange_Memoised(coins, amount - coins[index], n, dp);
                ans = coinCount != Integer.MAX_VALUE ? Math.min(ans, 1 + coinCount) : ans;
            }
        }
        return dp[amount] = ans;
    }

    public int coinChange_TopDown(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int amt = 1; amt <= amount; amt++) {
            int ans = Integer.MAX_VALUE;
            for (int index = 0; index < coins.length; index++) {
                if (coins[index] <= amt) {
                    int coinCount = dp[amt - coins[index]];
                    ans = coinCount != Integer.MAX_VALUE ? Math.min(ans, 1 + coinCount) : ans;
                }
            }
            dp[amt] = ans;
        }
        return dp[amount];
    }
}