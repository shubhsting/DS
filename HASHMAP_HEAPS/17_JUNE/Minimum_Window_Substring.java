// https://leetcode.com/problems/minimum-window-substring/description/
class Solution {
    public String minWindow(String s, String p) {
        HashMap<Character, Integer> characterCount = new HashMap<>();
        for (int index = 0; index < p.length(); index++) {
            char ch = p.charAt(index);
            characterCount.put(ch, characterCount.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        int ansLength = Integer.MAX_VALUE;
        String ansStr = "";
        int index = 0;
        int matchedCharCount = 0;
        HashMap<Character, Integer> stringCount = new HashMap<>();
        while (index < s.length()) {
            // acquire
            if (matchedCharCount < p.length()) {
                char ch = s.charAt(index);
                stringCount.put(ch, stringCount.getOrDefault(ch, 0) + 1);
                if (stringCount.get(ch) <= characterCount.getOrDefault(ch, 0))
                    matchedCharCount++;
                index++;
            }
            // release
            while (matchedCharCount == p.length()) {
                if (index - start < ansLength) {
                    ansLength = index - start;
                    ansStr = s.substring(start, index);
                }
                char ch = s.charAt(start);
                stringCount.put(ch, stringCount.getOrDefault(ch, 0) - 1);
                if (stringCount.get(ch) < characterCount.getOrDefault(ch, 0))
                    matchedCharCount--;
                start++;
            }
        }
        return ansStr;
    }

}
