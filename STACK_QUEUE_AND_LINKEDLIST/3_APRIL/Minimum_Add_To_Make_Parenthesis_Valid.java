// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    st.push(ch);
                    continue;
                }
                if (ch == ')' && st.peek() == '(')
                    st.pop();
                else
                    st.push(ch);
            }
        }
        return st.size();
    }
}