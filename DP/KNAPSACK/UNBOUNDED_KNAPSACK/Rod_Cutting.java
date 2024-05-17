package DP.KNAPSACK.UNBOUNDED_KNAPSACK;
// https://www.geeksforgeeks.org/problems/rod-cutting0840/1
class Solution {
    public int cutRod(int price[], int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return cutRod_Memoised(price, n, dp);
        return cutRod_topDown(price, n);
    }

    public int cutRod_Recursive(int[] price, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return price[0];
        }
        int ans = Integer.MIN_VALUE;
        for (int cut = 1; cut <= n; cut++) {
            ans = Math.max(ans, price[cut - 1] + cutRod_Recursive(price, n - cut));
        }
        return ans;
    }

    public int cutRod_Memoised(int[] price, int n, int[] dp) {
        if (n == 0) {
            return dp[n] = 0;
        }
        if (n == 1) {
            return dp[n] = price[0];
        }
        if (dp[n] != -1)
            return dp[n];
        int ans = Integer.MIN_VALUE;
        for (int cut = 1; cut <= n; cut++) {
            ans = Math.max(ans, price[cut - 1] + cutRod_Memoised(price, n - cut, dp));
        }
        return dp[n] = ans;
    }

    public int cutRod_topDown(int[] price, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int length = 1; length <= n; length++) {
            int ans = Integer.MIN_VALUE;
            for (int cut = 1; cut <= length; cut++) {
                ans = Math.max(ans, price[cut - 1] + dp[length - cut]);
            }
            dp[length] = ans;
        }
        return dp[n];
    }
}
