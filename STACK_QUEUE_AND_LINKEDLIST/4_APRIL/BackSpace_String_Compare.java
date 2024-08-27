//https://leetcode.com/problems/backspace-string-compare/description/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (!st.isEmpty() && ch == '#')
                st.pop();
            else if (ch != '#')
                st.push(ch);
        }

        Stack<Character> st2 = new Stack<>();
        for (int index = 0; index < t.length(); index++) {
            char ch = t.charAt(index);
            if (!st2.isEmpty() && ch == '#')
                st2.pop();
            else if (ch != '#')
                st2.push(ch);
        }

        if (st.size() != st2.size())
            return false;
        while (!st.isEmpty() && !st2.isEmpty()) {
            if (st.pop() != st2.pop())
                return false;
        }
        return true;
    }
}