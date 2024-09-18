// https://leetcode.com/problems/remove-element/description

// order is not maintained
class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        int ans = 0;
        while (start <= end) {
            if (nums[start] != val) {
                ans++;
                start++;
            } else if (nums[end] == val) {
                end--;
            } else {
                ans++;
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        return ans;
    }
}

// order of elements should be same..it is done with 2 pointers we keep
// reference of next empty space with us.
class Solution {
    public int removeElement(int[] nums, int val) {
        int startGap = -1;
        int endGap = -1;
        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != val) {
                count++;
                if (startGap != -1 && startGap < endGap) {
                    int newStart = nums[startGap];
                    nums[startGap] = nums[index];
                    startGap = newStart;
                    nums[endGap] = index;
                    endGap = index;
                } else if (startGap != -1 && startGap == endGap) {
                    nums[startGap] = nums[index];
                    startGap = index;
                    endGap = index;
                }
            } else {
                nums[index] = -1;
                if (endGap != -1)
                    nums[endGap] = index;
                endGap = index;
                if (startGap == -1)
                    startGap = index;
            }
        }
        return count;
    }
}