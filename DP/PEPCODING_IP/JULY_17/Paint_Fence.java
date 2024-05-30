package DP.PEPCODING_IP.JULY_17;
// https://www.lintcode.com/problem/514/description
public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        int last2Same = k;
        int last2Different = k * (k - 1);
        for (int post = 3; post <= n; post++) {
            int temp = (last2Same + last2Different) * (k - 1);
            last2Same = last2Different;
            last2Different = temp;

        }
        return last2Same + last2Different;
    }
}