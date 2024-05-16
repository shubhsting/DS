package DP.KNAPSACK;
// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution {

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // int[][] dp = new int[N+1][sum+1];
        // for(int[] ar: dp) {
        // Arrays.fill(ar, -1);
        // }
        // int ans = isSubsetSum_Memoised(N, arr, sum, dp);
        // return ans >=1 ? true:false;

        return isSubsetSum_TopDown(N, arr, sum);
    }

    static Boolean isSubsetSum_Recursive(int N, int[] arr, int sum) {
        if (sum == 0)
            return true;
        if (N == 0)
            return false;

        if (arr[N - 1] > sum) {
            return isSubsetSum_Recursive(N - 1, arr, sum);
        }
        return isSubsetSum_Recursive(N - 1, arr, sum) || isSubsetSum_Recursive(N - 1, arr, sum - arr[N - 1]);
    }

    static int isSubsetSum_Memoised(int N, int[] arr, int sum, int[][] dp) {
        if (sum == 0)
            return dp[N][sum] = 1;
        if (N == 0)
            return dp[N][sum] = 0;
        if (dp[N][sum] != -1)
            return dp[N][sum];
        if (arr[N - 1] > sum) {
            return dp[N][sum] = isSubsetSum_Memoised(N - 1, arr, sum, dp);
        }
        boolean ans = (isSubsetSum_Memoised(N - 1, arr, sum, dp) == 1)
                || (isSubsetSum_Memoised(N - 1, arr, sum - arr[N - 1], dp) == 1);
        return dp[N][sum] = ans ? 1 : 0;
    }

    static boolean isSubsetSum_TopDown(int N, int[] arr, int subset_sum) {
        boolean[][] dp = new boolean[N + 1][subset_sum + 1];
        for (int noOfElements = 0; noOfElements <= N; noOfElements++) {
            for (int sum = 0; sum <= subset_sum; sum++) {
                if (sum == 0) {
                    dp[noOfElements][0] = true;
                    continue;
                } else if (noOfElements == 0) {
                    dp[0][sum] = false;
                    continue;
                } else {
                    if (arr[noOfElements - 1] > sum) {
                        dp[noOfElements][sum] = dp[noOfElements - 1][sum];
                    } else {
                        dp[noOfElements][sum] = dp[noOfElements - 1][sum]
                                || dp[noOfElements - 1][sum - arr[noOfElements - 1]];
                    }
                }
            }
        }
        return dp[N][subset_sum];
    }

}
