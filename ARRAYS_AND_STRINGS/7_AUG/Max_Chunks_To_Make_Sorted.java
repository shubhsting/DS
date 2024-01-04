class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int index = 0; index < arr.length; index++) {
            maxSoFar = Math.max(maxSoFar, arr[index]);
            if (maxSoFar == index) {
                ans += 1;
                maxSoFar = Integer.MIN_VALUE;
            }
        }
        return ans;
    }
}
