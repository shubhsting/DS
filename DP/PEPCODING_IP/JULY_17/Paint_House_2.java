package DP.PEPCODING_IP.JULY_17;
// https://www.lintcode.com/problem/516/description
public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int previousMin = Integer.MAX_VALUE;
        int previousSecondMin = Integer.MAX_VALUE;

        for (int row = 0; row < costs.length; row++) {
            int currentMin = Integer.MAX_VALUE;
            int currentSecondMin = Integer.MAX_VALUE;

            for (int column = 0; column < costs[0].length; column++) {
                if (row > 0) {
                    costs[row][column] += costs[row - 1][column] == previousMin ? previousSecondMin : previousMin;
                }
                if (costs[row][column] <= currentMin) {
                    currentSecondMin = currentMin;
                    currentMin = costs[row][column];
                } else {
                    currentSecondMin = Math.min(currentSecondMin, costs[row][column]);
                }

            }

            previousMin = currentMin;
            previousSecondMin = currentSecondMin;
        }
        return Math.min(previousMin, previousSecondMin);
    }
}
