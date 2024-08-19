// https://www.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int index = 0; index < s1.length(); index++) {
            char ch = s1.charAt(index);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (int index = 0; index < s2.length(); index++) {
            char ch = s2.charAt(index);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int ans = 0;
        for (char key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key) - map2.get(key) > 0) {
                ans += map1.get(key) - map2.get(key);
            } else if (!map2.containsKey(key)) {
                ans += map1.get(key);
            }
        }
        return ans <= k;
    }
}