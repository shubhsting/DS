package DP.PEPCODING_IP.JULY_24;
//https://www.geeksforgeeks.org/problems/lcs-of-three-strings0028/1
class Solution {
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) {

        return LCS(A, B, C, n1, n2, n3);
    }

    public int LCS(String A, String B, String C, int n1, int n2, int n3) {
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for (int index1 = 0; index1 <= n1; index1++) {
            for (int index2 = 0; index2 <= n2; index2++) {
                for (int index3 = 0; index3 <= n3; index3++) {
                    if (index1 == 0 || index2 == 0 || index3 == 0) {
                        continue;
                    }
                    if ((A.charAt(index1 - 1) == B.charAt(index2 - 1))
                            && (C.charAt(index3 - 1) == B.charAt(index2 - 1))) {
                        dp[index1][index2][index3] = 1 + dp[index1 - 1][index2 - 1][index3 - 1];
                    } else {
                        dp[index1][index2][index3] = Math.max(
                                Math.max(dp[index1][index2 - 1][index3], dp[index1][index2][index3 - 1]),
                                dp[index1 - 1][index2][index3]);
                    }
                }
            }
        }
        return dp[n1][n2][n3];
    }
}
