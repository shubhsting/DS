// https://www.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1
class solve {
    // Function to find the maximum possible amount of money we can win.
    static long maximumAmount(int arr[], int n) {
        int[][] dp = new int[arr.length][arr.length];

        for (int gap = 0; gap < n; gap++) {
            for (int row = 0; row < n - gap; row++) {
                int col = row + gap;
                if (gap == 0 || gap == 1) {
                    dp[row][col] = Math.max(arr[row], arr[col]);
                    continue;
                }

                int option1 = Math.min(dp[row + 1][col - 1], dp[row + 2][col]) + arr[row];
                int option2 = Math.min(dp[row + 1][col - 1], dp[row][col - 2]) + arr[col];
                dp[row][col] = Math.max(option1, option2);
            }
        }
        return dp[0][n - 1];
    }

    // static long test(int[] arr, int start, int end, boolean myTurn) {

    // }
}