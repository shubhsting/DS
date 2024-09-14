// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
class Solution {
    public int minCost(int n, int[] cuts) {
        int[] cutsNew = new int[cuts.length + 2];
        for (int index = 0; index < cuts.length; index++)
            cutsNew[index + 1] = cuts[index];
        cutsNew[cutsNew.length - 1] = n;
        int[][] dp = new int[cutsNew.length][cutsNew.length];
        Arrays.sort(cutsNew);
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return cost(cutsNew, 0, cutsNew.length - 1, dp);
    }

    public int cost(int[] cuts, int start, int end, int[][] dp) {
        int ans = Integer.MAX_VALUE;
        if (end - start == 1)
            return 0;
        if (dp[start][end] != -1)
            return dp[start][end];
        for (int index = start + 1; index < end; index++) {
            int temp = cost(cuts, start, index, dp) + cost(cuts, index, end, dp) + (cuts[end] - cuts[start]);
            ans = Math.min(ans, temp);
        }
        return dp[start][end] = ans;
    }
}
