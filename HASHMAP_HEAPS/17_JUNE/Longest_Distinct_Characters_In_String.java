//https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1
class Solution {
    static int longestSubstrDistinctChars(String S) {
        int ans = 0;
        int start = 0;
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        for (int index = 0; index < S.length(); index++) {
            char ch = S.charAt(index);
            if (lastIndex.containsKey(ch) && lastIndex.get(ch) >= start) {
                start = lastIndex.get(ch) + 1;
            }
            ans = Math.max(ans, index - start + 1);
            lastIndex.put(ch, index);
        }
        return ans;

    }
}