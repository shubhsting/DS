import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/majority-element-ii/description/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int[] elements = new int[2];
        int[] counts = new int[2];
        elements[0] = nums[0];
        counts[0] = 1;

        for (int index = 1; index < nums.length; index++) {

            if (isElementPresent(nums[index], elements, counts)
                    || isZeroCountElementPresent(nums[index], elements, counts)) {
                continue;
            } else {
                for (int elementIdx = 0; elementIdx < elements.length; elementIdx++) {
                    counts[elementIdx] -= 1;
                }

            }
        }

        Arrays.fill(counts, 0);
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            for (int elementIdx = 0; elementIdx < elements.length; elementIdx++) {
                if (elements[elementIdx] == nums[index]) {
                    counts[elementIdx] += 1;
                }
            }
        }

        for (int elementIdx = 0; elementIdx < elements.length; elementIdx++) {
            if (counts[elementIdx] > nums.length / 3 && ans.indexOf(elements[elementIdx]) == -1) {
                ans.add(elements[elementIdx]);
            }
        }
        return ans;
    }

    public boolean isElementPresent(int element, int[] elements, int[] counts) {
        for (int index = 0; index < elements.length; index++) {
            if (elements[index] == element) {
                counts[index]++;
                return true;
            }
        }
        return false;
    }

    public boolean isZeroCountElementPresent(int element, int[] elements, int[] counts) {
        for (int index = 0; index < elements.length; index++) {
            if (counts[index] == 0) {
                elements[index] = element;
                counts[index] = 1;
                return true;
            }
        }
        return false;
    }
}