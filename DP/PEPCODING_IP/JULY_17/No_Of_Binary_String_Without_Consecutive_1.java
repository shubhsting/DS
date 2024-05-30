package DP.PEPCODING_IP.JULY_17;
// https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
class Solution {
    long countStrings(int N) {
        long mod = (long) Math.pow(10, 9) + 7;
        long lastOne = 1;
        long lastZero = 1;
        for (int index = 2; index <= N; index++) {
            long temp = lastZero % mod;
            lastZero = (lastZero % mod + lastOne % mod) % mod;
            lastOne = temp;
        }

        long ans = (lastZero % mod + lastOne % mod) % mod;
        return ans;
    }
}
