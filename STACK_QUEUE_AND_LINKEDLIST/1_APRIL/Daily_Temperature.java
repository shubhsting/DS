//https://leetcode.com/problems/daily-temperatures/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int index = st.pop();
                temperatures[index] = i - index;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            temperatures[st.pop()] = 0;
        }
        return temperatures;
    }
}
