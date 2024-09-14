// https://leetcode.com/problems/ugly-number-ii/
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
        int[] nums = new int[n + 1];
        int pointer2 = 1;
        int pointer3 = 1;
        int pointer5 = 1;
        nums[1] = 1;
        for (int index = 2; index <= n; index++) {
            int nextugly = Math.min(nums[pointer2] * 2, Math.min(nums[pointer3] * 3, nums[pointer5] * 5));
            if (nextugly == nums[pointer2] * 2)
                pointer2++;
            if (nextugly == nums[pointer3] * 3)
                pointer3++;
            if (nextugly == nums[pointer5] * 5)
                pointer5++;
            nums[index] = nextugly;
        }
        return nums[n];
    }
}