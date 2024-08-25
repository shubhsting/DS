// https://leetcode.com/problems/largest-rectangle-in-histogram/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = Integer.MIN_VALUE;
        for (int index = 0; index < heights.length; index++) {
            // next smaller banda mil gya
            while (!st.isEmpty() && heights[index] < heights[st.peek()]) {
                int height = heights[st.pop()];
                int width;
                if (!st.isEmpty()) {
                    width = index - st.peek() - 1;
                } else {
                    width = index;
                }
                ans = Math.max(ans, width * height);
            }
            st.push(index);
        }

        while (!st.isEmpty()) {
            int height = heights[st.pop()];
            int width;
            if (!st.isEmpty()) {
                width = heights.length - st.peek() - 1;
            } else {
                width = heights.length;
            }
            ans = Math.max(ans, width * height);
        }
        return ans;
    }
}