package DP.PEPCODING_IP.JULY_17;
//https://www.lintcode.com/problem/515/description
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        for (int index = 1; index < costs.length; index++) {
            costs[index][0] += Math.min(costs[index - 1][1], costs[index - 1][2]);
            costs[index][1] += Math.min(costs[index - 1][0], costs[index - 1][2]);
            costs[index][2] += Math.min(costs[index - 1][0], costs[index - 1][1]);
        }
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}
