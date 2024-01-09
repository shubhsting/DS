class Solution {
    // https://www.lintcode.com/problem/903/
    /**
     * @param length:  the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] update : updates) {
            ans[update[0]] += update[2];
            if (update[1] + 1 < length) {
                ans[update[1] + 1] -= update[2];
            }
        }

        for (int index = 1; index < length; index++) {
            ans[index] = ans[index] + ans[index - 1];
        }
        return ans;
    }
}
