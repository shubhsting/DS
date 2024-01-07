class Solution {
    // https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        prefixMax[0] = arr[0];
        for (int index = 1; index < n; index++) {
            prefixMax[index] = Math.max(prefixMax[index - 1], arr[index]);
        }
        suffixMin[n - 1] = arr[n - 1];
        for (int index = n - 2; index >= 0; index--) {
            suffixMin[index] = Math.min(arr[index], suffixMin[index + 1]);
        }
        int ans = 1;

        for (int index = 0; index < n - 1; index++) {
            if (prefixMax[index] <= suffixMin[index + 1]) {
                ans++;
            }
        }
        return ans;

    }
}
