// https://www.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        HashMap<Character, Boolean> present = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            present.put(ch, false);
        }
        Stack<Character> st = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (present.get(ch)) {
                frequency.put(ch, frequency.get(ch) - 1);
                continue;
            }
            while (!st.isEmpty() && st.peek() > ch && frequency.get(st.peek()) > 0) {
                char p = st.pop();
                present.put(p, false);
            }
            st.push(ch);
            present.put(ch, true);
            frequency.put(ch, frequency.get(ch) - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}