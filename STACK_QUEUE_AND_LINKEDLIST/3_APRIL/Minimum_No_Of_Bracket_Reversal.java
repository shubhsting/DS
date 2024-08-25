// https://www.geeksforgeeks.org/problems/count-the-reversals0401/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
class Sol {
    int countRev(String s) {
        Stack<Character> st = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    st.push(ch);
                    continue;
                }
                if (ch == '}' && st.peek() == '{')
                    st.pop();
                else if (ch == ']' && st.peek() == '[')
                    st.pop();
                else if (ch == ')' && st.peek() == '(')
                    st.pop();
                else
                    st.push(ch);
            }
        }
        if (st.size() % 2 != 0)
            return -1;
        int ans = 0;
        while (!st.isEmpty()) {
            char ch = st.pop();
            char ch1 = st.pop();
            if ((ch1 == '{' && ch == '{') || (ch1 == '}' && ch == '}'))
                ans += 1;
            else
                ans += 2;
        }
        return ans;
    }
}
