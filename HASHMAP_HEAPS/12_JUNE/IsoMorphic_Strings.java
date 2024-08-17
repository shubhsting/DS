//https://leetcode.com/problems/isomorphic-strings/description/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map_s = new HashMap<>();
        HashMap<Character, Character> map_t = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char first = s.charAt(index);
            char second = t.charAt(index);
            if (map_s.containsKey(first) && map_s.get(first) != second)
                return false;
            if (map_t.containsKey(second) && map_t.get(second) != first)
                return false;
            map_s.put(first, second);
            map_t.put(second, first);
        }
        return true;
    }
}