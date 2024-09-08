// https://leetcode.com/problems/single-number-iii/description/

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor_of_both_nums = 0;
        for (int num : nums)
            xor_of_both_nums ^= num;

        int[] ans = new int[2];
        int rightSetBitOfXor = rightSetBit(xor_of_both_nums);
        for (int num : nums) {
            int andResult = rightSetBitOfXor & num; // we'll do and to check if there is a bit at that place
            if (andResult != 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;
        }

        return ans;
    }

    public int rightSetBit(int num) {
        return (num & (-num));
    }
}