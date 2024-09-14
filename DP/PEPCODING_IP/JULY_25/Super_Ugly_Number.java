//https://leetcode.com/problems/super-ugly-number/
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] lastUglyIndices = new int[primes.length];
        Arrays.fill(lastUglyIndices, 1);

        long[] ugly = new long[n + 1];
        ugly[1] = 1;
        for (int index = 2; index <= n; index++) {
            long nextUgly = Integer.MAX_VALUE;
            for (int idx = 0; idx < primes.length; idx++) {
                nextUgly = Math.min(nextUgly, ugly[lastUglyIndices[idx]] * primes[idx]);
            }

            for (int idx = 0; idx < primes.length; idx++) {
                if (ugly[lastUglyIndices[idx]] * primes[idx] == nextUgly)
                    lastUglyIndices[idx]++;
            }
            ugly[index] = nextUgly;
        }
        return (int) ugly[n];
    }
}