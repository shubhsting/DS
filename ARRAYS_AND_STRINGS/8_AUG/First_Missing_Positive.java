class Solution {
    // https://leetcode.com/problems/first-missing-positive/description/
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int currentIndex = 0;

        while (currentIndex < nums.length) {
            if (nums[currentIndex] <= 0 || nums[currentIndex] > n || (nums[currentIndex] - 1 == currentIndex)) {
                currentIndex++;
            } else {
                int swapIndex = nums[currentIndex] - 1;
                if (nums[swapIndex] == nums[currentIndex]) {
                    currentIndex++;
                    continue;
                }
                int temp = nums[swapIndex];
                nums[swapIndex] = nums[currentIndex];
                nums[currentIndex] = temp;
            }
        }

        for (int index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        return n + 1;
    }
}
