// https://leetcode.com/problems/validate-stack-sequences/description/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int popIndex = 0;
        for (int index = 0; index < pushed.length; index++) {
            st.push(pushed[index]);
            while (!st.isEmpty() && st.peek() == popped[popIndex]) {
                st.pop();
                popIndex++;
            }
        }
        return st.isEmpty();
    }
}
