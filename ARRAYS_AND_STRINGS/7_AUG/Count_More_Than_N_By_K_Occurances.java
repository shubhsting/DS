import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
class Solution1UsingMooreVoterAlgorithm {
    // Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] nums, int n, int k) {
        if (k == 1) {
            return 0;
        }

        int[] elements = new int[k - 1];
        int[] counts = new int[k - 1];
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
            if (counts[elementIdx] > nums.length / k && ans.indexOf(elements[elementIdx]) == -1) {
                ans.add(elements[elementIdx]);
            }
        }
        return ans.size();
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
