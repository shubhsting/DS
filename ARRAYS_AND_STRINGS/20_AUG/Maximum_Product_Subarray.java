class Solution {
    // https://leetcode.com/problems/maximum-product-subarray/description/
    public int maxProduct(int[] nums) {
        int product = 1;
        boolean zeroPresent = false;
        int maximumProduct = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                product = 1;
                zeroPresent = true;
                continue;
            }
            product = product * nums[index];
            if (product > maximumProduct) {
                maximumProduct = product;
            }
        }

        product = 1;
        for (int index = nums.length - 1; index >= 0; index--) {
            if (nums[index] == 0) {
                product = 1;
                zeroPresent = true;
                continue;
            }
            product = product * nums[index];
            if (product > maximumProduct) {
                maximumProduct = product;
            }
        }
        return zeroPresent ? Math.max(maximumProduct, 0) : maximumProduct;
    }
}
