// https://www.geeksforgeeks.org/problems/longest-valid-parentheses5657/1
class Solution {
    static int maxLength(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(index);
            } else {
                if (st.isEmpty()) {
                    st.push(index);
                    continue;
                }
                char ch2 = s.charAt(st.peek());
                if ((ch == '}' && ch2 == '{') || (ch == ']' && ch2 == '[') || (ch == ')' && ch2 == '(')) {
                    st.pop();
                    ans = !st.isEmpty() ? Math.max(ans, index - st.peek()) : Math.max(ans, index + 1);
                } else
                    st.push(index);
            }
        }

        return ans;
    }

}
