package DP.PEPCODING_IP.JULY_22;
// https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
class Solution {
    static int matrixMultiplication(int N, int arr[]) {
        // int[][] dp = new int[N][N];
        // for(int[] ar: dp) {
        // Arrays.fill(ar, -1);
        // }

        // return matrixMultiplicationMemoised(N, arr, 1, arr.length - 1, dp);
        return matrixMultiplicationTopDown(N, arr);
    }

    static int matrixMultiplicationRecursive(int N, int arr[], int start, int end) {
        if (start == end) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int partition = start; partition < end; partition++) {
            int current = matrixMultiplicationRecursive(N, arr, start, partition)
                    + matrixMultiplicationRecursive(N, arr, partition + 1, end)
                    + arr[start - 1] * arr[partition] * arr[end];
            ans = Math.min(ans, current);
        }
        return ans;
    }

    static int matrixMultiplicationMemoised(int N, int arr[], int start, int end, int[][] dp) {
        if (start == end) {
            return dp[start][end] = 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for (int partition = start; partition < end; partition++) {
            int current = matrixMultiplicationMemoised(N, arr, start, partition, dp)
                    + matrixMultiplicationMemoised(N, arr, partition + 1, end, dp)
                    + arr[start - 1] * arr[partition] * arr[end];
            ans = Math.min(ans, current);
        }
        return dp[start][end] = ans;
    }

    static int matrixMultiplicationTopDown(int N, int arr[]) {
        int[][] dp = new int[N][N];
        for (int cut = 0; cut < N; cut++) {
            for (int row = 1; row < N - cut; row++) {
                int column = row + cut;
                if (row == column) {
                    continue;
                }
                int ans = Integer.MAX_VALUE;
                for (int partition = row; partition < column; partition++) {
                    int current = dp[row][partition] + dp[partition + 1][column]
                            + arr[row - 1] * arr[partition] * arr[column];
                    ans = Math.min(ans, current);
                }
                dp[row][column] = ans;
            }
        }
        return dp[1][N - 1];
    }

}