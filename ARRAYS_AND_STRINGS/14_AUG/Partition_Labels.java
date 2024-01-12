import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/partition-labels/description/
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < s.length(); index++) {
            lastIndex[s.charAt(index) - 'a'] = index;
        }
        int currentIndex = 0;
        int currentPartitionRangeEnd = -1;
        int currentRangeStart = 0;

        while (currentIndex < s.length()) {
            int character = s.charAt(currentIndex) - 'a';
            if (currentPartitionRangeEnd < lastIndex[character]) {
                currentPartitionRangeEnd = lastIndex[character];
            }
            if (currentIndex == currentPartitionRangeEnd) {
                ans.add(currentIndex - currentRangeStart + 1);
                currentRangeStart = currentIndex + 1;
            }
            currentIndex++;
        }
        return ans;
    }
}