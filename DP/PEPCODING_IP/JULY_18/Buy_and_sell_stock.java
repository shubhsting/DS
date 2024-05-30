package DP.PEPCODING_IP.JULY_18;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
class Solution {
    // dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + costs[i]);
    // dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - costs[i]);

    // for this question k = 1
    // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + costs[i]);
    // dp[i][1] = max(dp[i-1][1], -costs[i])
    public int maxProfit(int[] prices) {
        int profit_ith_day_0_in_hand = 0;
        int profit_ith_day_1_in_hand = Integer.MIN_VALUE;
        for (int index = 0; index < prices.length; index++) {
            if (profit_ith_day_1_in_hand != Integer.MIN_VALUE) {
                profit_ith_day_0_in_hand = Math.max(profit_ith_day_0_in_hand, profit_ith_day_1_in_hand + prices[index]);
            }
            profit_ith_day_1_in_hand = Math.max(profit_ith_day_1_in_hand, -prices[index]);
        }
        return Math.max(profit_ith_day_0_in_hand, profit_ith_day_1_in_hand);
    }
}