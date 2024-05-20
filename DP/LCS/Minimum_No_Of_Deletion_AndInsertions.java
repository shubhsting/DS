package DP.LCS;
// this is first normal solution
// second is lcs solution-> Transform first string to LCS and then add new elements. So answer is..
// no of deletions -> length of first string - LCS length 
// no of additions - > length of second string - LCS length
class Solution {
    public int minOperations(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return test(str1, str2, str1.length(), str2.length(), dp);
    }

    public int test(String str1, String str2, int index1, int index2, int[][] dp) {
        if (index1 == 0 && index2 == 0) {
            return dp[index1][index2] = 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        // System.out.println(index1 + "," + index2);
        if (index1 == 0 || index2 == 0) {
            return dp[index1][index2] = index2 == 0 ? index1 : index2;
        }
        if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
            return dp[index1][index2] = test(str1, str2, index1 - 1, index2 - 1, dp);
        }

        int removeFromString1 = test(str1, str2, index1 - 1, index2, dp) + 1;
        int addToString1 = test(str1, str2, index1, index2 - 1, dp) + 1;

        return dp[index1][index2] = Math.min(removeFromString1, addToString1);
    }
}
