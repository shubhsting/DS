import java.util.*;
import java.io.*;

// important
// https://www.naukri.com/code360/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM
public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n + 1][tar + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findWays_Memoised(num, tar, n, dp);
        // return findWays_TopDown(num, tar, n);
    }

    public static int findWays_Memoised(int[] num, int target, int n, int[][] dp) {
        if (n == 0) {
            return dp[n][target] = target == 0 ? 1 : 0;
        }
        if (dp[n][target] != -1)
            return dp[n][target];
        if (num[n - 1] > target) {
            return dp[n][target] = (int) (findWays_Memoised(num, target, n - 1, dp) % (Math.pow(10, 9) + 7));
        }

        int include = (int) (findWays_Memoised(num, target - num[n - 1], n - 1, dp) % (Math.pow(10, 9) + 7));
        int exclude = (int) (findWays_Memoised(num, target, n - 1, dp) % (Math.pow(10, 9) + 7));
        return dp[n][target] = (int) ((include + exclude) % (Math.pow(10, 9) + 7));
    }

    public static int findWays_TopDown(int[] num, int target, int n) {
        int[][] dp = new int[n + 1][target + 1];
        for (int noOfElements = 0; noOfElements <= n; noOfElements++) {
            for (int sum = 0; sum <= target; sum++) {
                if (noOfElements == 0) {
                    dp[noOfElements][sum] = sum == 0 ? 1 : 0;
                    continue;
                }

                int exclude = dp[noOfElements - 1][sum];
                int include = 0;
                if (sum >= num[noOfElements - 1])
                    include = dp[noOfElements - 1][sum - num[noOfElements - 1]];
                dp[noOfElements][sum] = (int) ((include + exclude) % (Math.pow(10, 9) + 7));
            }
        }
        return dp[n][target];
    }
}