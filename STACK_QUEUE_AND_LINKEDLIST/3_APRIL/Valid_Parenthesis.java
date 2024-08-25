//https://leetcode.com/problems/valid-parentheses/description/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if(st.isEmpty()) {
                    st.push(ch);
                    continue;
                }
                if(ch == '}' && st.peek() == '{') st.pop();
                else if(ch == ']' && st.peek() == '[') st.pop();
                else if(ch == ')' && st.peek() == '(') st.pop();
                else st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
