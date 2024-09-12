// https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int maxSum = 0;
        for (int task : tasks)
            maxSum += task;
        int[][] dp = new int[maxSum][(1 << tasks.length) - 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return minTask(tasks, sessionTime, 0, 0, dp) + 1;
    }

    public int minTask(int[] tasks, int sessionTime, int currentTime, int mask, int[][] dp) {
        if (mask == (1 << tasks.length) - 1)
            return 0;
        int ans = Integer.MAX_VALUE;

        if (dp[currentTime][mask] != -1)
            return dp[currentTime][mask];

        for (int index = tasks.length - 1; index >= 0; index--) {
            int gap = tasks.length - 1 - index;
            boolean isCurrentFree = (mask & (1 << gap)) == 0;
            if (isCurrentFree && currentTime + tasks[index] <= sessionTime) {
                ans = Math.min(ans, minTask(tasks, sessionTime, currentTime + tasks[index], mask | 1 << gap, dp));
            } else if (isCurrentFree) {
                ans = Math.min(ans, minTask(tasks, sessionTime, tasks[index], mask | 1 << gap, dp) + 1);
            }
        }
        return dp[currentTime][mask] = ans;
    }
}