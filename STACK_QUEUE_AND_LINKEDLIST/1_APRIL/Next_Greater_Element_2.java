// https://leetcode.com/problems/next-greater-element-ii/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;
            while (!st.isEmpty() && nums[st.peek()] < nums[index]) {
                int idx = st.pop();
                arr[idx] = nums[index];
            }
            st.push(index);
        }

        return arr;
    }
}
