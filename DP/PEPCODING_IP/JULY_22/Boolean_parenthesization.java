package DP.PEPCODING_IP.JULY_22;
// https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1
class Solution {
    static int countWays(int n, String s) {
        // return MCM(s, 0, s.length(), true);
        return P_MCM_TOP_DOWN(s, n);
    }

    static int MCM(String s, int start, int end, boolean result) {
        if (start + 1 == end) {
            char ch = s.charAt(start);
            return ((ch == 'T' && result) || (ch == 'F' && !result)) ? 1 : 0;
        }
        int ans = 0;
        for (int index = start + 1; index < end; index += 2) {
            char symbol = s.charAt(index);
            int noOfWaysTrueFirstPartition = MCM(s, start, index, true);
            int noOfWaysTrueSecondPartition = MCM(s, index + 1, end, true);
            int noOfWaysFalseFirstPartition = MCM(s, start, index, false);
            int noOfWaysFalseSecondPartition = MCM(s, index + 1, end, false);
            ans += getNoOfWaysForSymbol(symbol, noOfWaysTrueFirstPartition, noOfWaysTrueSecondPartition,
                    noOfWaysFalseFirstPartition, noOfWaysFalseSecondPartition, result);
        }
        return ans;
    }

    private static int getNoOfWaysForSymbol(char symbol, int t1, int t2, int f1, int f2, boolean result) {
        int MOD = 1003;
        if (symbol == '&') {
            return result ? (t1 * t2) % MOD : ((t1 * f2) % MOD + (f1 * t2) % MOD + (f1 * f2) % MOD) % MOD;
        } else if (symbol == '|') {
            return result ? ((t1 * f2) % MOD + (f1 * t2) % MOD + (t1 * t2) % MOD) % MOD : (f1 * f2) % MOD;
        } else {
            return result ? ((t1 * f2) % MOD + (f1 * t2) % MOD) % MOD : ((t1 * t2) % MOD + (f1 * f2) % MOD) % MOD;
        }
    }

    public static int P_MCM_TOP_DOWN(String s, int n) {
        int MOD = 1003;
        int[][] dp_true = new int[n + 1][n + 1];
        int[][] dp_false = new int[n + 1][n + 1];
        for (int gap = 1; gap <= n; gap++) {
            for (int row = 0; row <= n - gap; row++) {
                int column = row + gap;
                if (gap == 1) {
                    char ch = s.charAt(row);
                    dp_true[row][column] = ch == 'T' ? 1 : 0;
                    dp_false[row][column] = ch == 'F' ? 1 : 0;
                    continue;
                }
                for (int index = row + 1; index < column; index += 2) {
                    char symbol = s.charAt(index);
                    int noOfWaysTrueFirstPartition = dp_true[row][index];
                    int noOfWaysTrueSecondPartition = dp_true[index + 1][column];
                    int noOfWaysFalseFirstPartition = dp_false[row][index];
                    int noOfWaysFalseSecondPartition = dp_false[index + 1][column];
                    dp_true[row][column] = ((dp_true[row][column] % MOD)
                            + (getNoOfWaysForSymbol(symbol, noOfWaysTrueFirstPartition, noOfWaysTrueSecondPartition,
                                    noOfWaysFalseFirstPartition, noOfWaysFalseSecondPartition, true) % MOD))
                            % MOD;
                    dp_false[row][column] = ((dp_false[row][column] % MOD)
                            + (getNoOfWaysForSymbol(symbol, noOfWaysTrueFirstPartition, noOfWaysTrueSecondPartition,
                                    noOfWaysFalseFirstPartition, noOfWaysFalseSecondPartition, false) % MOD))
                            % MOD;
                }

            }
        }

        return dp_true[0][n];
    }

}
