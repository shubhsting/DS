package DP.PEPCODING_IP.JULY_17;
// https://www.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1
class Solution {
    public int TotalWays(int N) {
        long mod = (long) Math.pow(10, 9) + 7;
        long lastBuilding = 1;
        long lastEmpty = 1;
        for (int index = 2; index <= N; index++) {
            long temp = lastEmpty % mod;
            lastEmpty = (lastBuilding % mod + lastEmpty % mod) % mod;
            lastBuilding = temp;
        }

        long ans = (lastBuilding % mod + lastEmpty % mod) % mod;
        return (int) (((ans % mod) * (ans % mod)) % mod);
    }
}
