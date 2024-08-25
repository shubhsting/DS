// https://www.geeksforgeeks.org/problems/expression-contains-redundant-bracket-or-not/1
class Solution {
    public static int checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (ch != ')')
                st.push(ch);
            else {
                // if((st.isEmpty()) || (!st.isEmpty() && st.peek() == '(') || (!st.isEmpty() &&
                // st.peek() == ')') ) return 1;
                int countElements = 0;
                while (!st.isEmpty() && st.peek() != '(') {
                    countElements++;
                    st.pop();
                }
                if (countElements <= 1)
                    return 1;
                st.pop();
            }
        }
        return 0;
    }
}
