
//https://leetcode.com/problems/group-anagrams/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            String processedString = processString(str);
            ans.putIfAbsent(processedString, new ArrayList<>());
            ans.get(processedString).add(str);
        }
        List<List<String>> finalStr = new ArrayList<>();
        for (String key : ans.keySet()) {
            finalStr.add(ans.get(key));
        }
        return finalStr;
    }

    public String processString(String str) {
        int[] freq = new int[26];
        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < 26; index++) {
            if (freq[index] > 0) {
                sb.append((char) ('a' + index) + "" + freq[index]);
            }
        }
        return sb.toString();
    }
}
