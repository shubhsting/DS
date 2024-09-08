//https://leetcode.com/problems/counting-bits/
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int index = 0; index <= n; index++)
            ans[index] = findSetBits(index);
        return ans;
    }

    public int findSetBits(int n) {
        if (n == 0)
            return 0;
        int count = 0;
        while (n > 0) {
            n = n - (n & -n);
            count++;
        }
        return count;
    }
}