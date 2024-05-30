package DP.PEPCODING_IP.JULY_18;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
class Solution {
    // dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + costs[i]);
    // dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - costs[i]);
    // for every k we need to create 2 variables and then update them accordingly.
    // for k = 2 we will have 4 variables.
    // dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + costs[i]);
    // dp[i][1][1] = max(dp[i-1][1][1], -costs[i])
    // dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + costs[i]);
    // dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - costs[i])
    public int maxProfit(int k, int[] prices) {
        int[] dp_0_stock_in_hand = new int[k + 1];
        int[] dp_1_stock_in_hand = new int[k + 1];
        Arrays.fill(dp_1_stock_in_hand, -prices[0]);
        for (int index = 1; index < prices.length; index++) {
            for (int transaction = k; transaction > 0; transaction--) {
                dp_0_stock_in_hand[transaction] = Math.max(dp_0_stock_in_hand[transaction],
                        dp_1_stock_in_hand[transaction] + prices[index]);
                dp_1_stock_in_hand[transaction] = Math.max(dp_1_stock_in_hand[transaction],
                        dp_0_stock_in_hand[transaction - 1] - prices[index]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int index = 1; index <= k; index++) {
            ans = Math.max(ans, dp_0_stock_in_hand[index]);
        }
        return ans;
    }
}
