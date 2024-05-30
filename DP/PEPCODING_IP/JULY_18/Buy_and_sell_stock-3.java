package DP.PEPCODING_IP.JULY_18;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
class Solution {
    // dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + costs[i]);
    // dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - costs[i]);

    // for this question k = 2 we will have 4 variables.
    // dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + costs[i]);
    // dp[i][1][1] = max(dp[i-1][1][1], -costs[i])
    // dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + costs[i]);
    // dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - costs[i])
    public int maxProfit(int[] costs) {
        int profit_ith_day_1_transaction_0_in_hand = 0;
        int profit_ith_day_2_transaction_0_in_hand = 0;
        int profit_ith_day_1_transaction_1_in_hand = -costs[0];
        int profit_ith_day_2_transaction_1_in_hand = -costs[0];
        for (int index = 1; index < costs.length; index++) {
            profit_ith_day_2_transaction_0_in_hand = Math.max(profit_ith_day_2_transaction_0_in_hand,
                    profit_ith_day_2_transaction_1_in_hand + costs[index]);
            profit_ith_day_2_transaction_1_in_hand = Math.max(profit_ith_day_2_transaction_1_in_hand,
                    profit_ith_day_1_transaction_0_in_hand - costs[index]);
            profit_ith_day_1_transaction_0_in_hand = Math.max(profit_ith_day_1_transaction_0_in_hand,
                    profit_ith_day_1_transaction_1_in_hand + costs[index]);
            profit_ith_day_1_transaction_1_in_hand = Math.max(profit_ith_day_1_transaction_1_in_hand, -costs[index]);
        }
        return Math.max(profit_ith_day_1_transaction_0_in_hand, profit_ith_day_2_transaction_0_in_hand);
    }
}