package DP.PEPCODING_IP.JULY_15;
// https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
class Solution {
    public class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<Job> jobs = new ArrayList<>();
        for (int index = 0; index < startTime.length; index++) {
            jobs.add(new Job(startTime[index], endTime[index], profit[index]));
        }
        Collections.sort(jobs, (Job a, Job b) -> {
            return a.start - b.start;
        });

        return LIS(jobs);
    }
    // this is n^2 approach and wiull give TLE
    public int LIS(ArrayList<Job> jobs) {
        int ans = 0;
        int[] dp = new int[jobs.size()];
        for (int index = 0; index < jobs.size(); index++) {
            int current_sub = jobs.get(index).profit;
            for (int window = 0; window < index; window++) {
                if (jobs.get(window).end <= jobs.get(index).start) {
                    current_sub = Math.max(current_sub, dp[window] + jobs.get(index).profit);
                }
            }
            dp[index] = current_sub;
            ans = Math.max(ans, dp[index]);
        }
        return ans;
    }
}
