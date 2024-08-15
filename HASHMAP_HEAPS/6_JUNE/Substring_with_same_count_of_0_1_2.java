// https://www.geeksforgeeks.org/problems/substrings-with-similar-first-and-last-characters3644/1
class Solution {
    long getSubstringWithEqual012(String s) {
        int prefix_count_0 = 0;
        int prefix_count_1 = 0;
        int prefix_count_2 = 0;
        long ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0*0", 1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                prefix_count_0++;
            } else if (s.charAt(i) == '1') {
                prefix_count_1++;
            } else {
                prefix_count_2++;
            }
            int diff1 = prefix_count_1 - prefix_count_0;
            int diff2 = prefix_count_2 - prefix_count_1;
            String diff = diff1 + "*" + diff2;
            map.putIfAbsent(diff, 0);
            ans += map.get(diff);
            map.put(diff, map.get(diff) + 1);
        }
        return ans;
    }
}