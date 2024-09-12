// https://leetcode.com/problems/knight-probability-in-chessboard/
class Solution {
    public double knightProbability(int n, int k, int r, int c) {
        double[][] current = new double[n][n];
        double[][] previous = new double[n][n];
        int[][] directions = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };
        int noOfMoves = 0;
        previous[r][c] = 1;
        while (noOfMoves < k) {
            for (int row = 0; row < n; row++) {
                for (int column = 0; column < n; column++) {
                    if (previous[row][column] != 0) {
                        for (int[] direction : directions) {
                            int nRow = row + direction[0];
                            int nColumn = column + direction[1];
                            if (nRow >= 0 && nRow < n && nColumn >= 0 && nColumn < n) {
                                current[nRow][nColumn] += (1.0 * previous[row][column]) / 8;
                            }
                        }
                    }
                }
            }
            previous = current;
            current = new double[n][n];
            noOfMoves++;
        }
        double ans = 0;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                ans += previous[row][column];
            }
        }
        return ans;
    }
}