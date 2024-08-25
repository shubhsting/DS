// https://leetcode.com/problems/remove-k-digits/
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        int removed = 0;
        for (int index = 0; index < num.length(); index++) {
            int no = num.charAt(index) - '0';
            while (!st.isEmpty() && st.peek() > no && removed < k) {
                removed++;
                st.pop();
            }
            st.push(no);
        }

        String str = "";
        while (!st.isEmpty()) {
            if (removed < k) {
                st.pop();
                removed++;
                continue;
            }
            str = st.pop() + str;
        }

        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        return i >= str.length() ? "0" : str.substring(i, str.length());
    }
}
