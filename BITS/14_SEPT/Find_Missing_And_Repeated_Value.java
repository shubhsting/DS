// https://leetcode.com/problems/find-missing-and-repeated-values/
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] nums = new int[2 * n * m];
        int index = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                nums[index] = grid[row][col];
                index++;
                nums[index] = row * n + col + 1;
                index++;
            }
        }
        int[] ans = singleNumber(nums);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (ans[0] == grid[row][col])
                    return ans;
            }
        }
        int temp = ans[0];
        ans[0] = ans[1];
        ans[1] = temp;
        return ans;
    }

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
