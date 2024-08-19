class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> characterCount = new HashMap<>();
        for (int index = 0; index < p.length(); index++) {
            char ch = p.charAt(index);
            characterCount.put(ch, characterCount.getOrDefault(ch, 0) + 1);
        }
        int index = 0;
        List<Integer> ans = new ArrayList<>();
        int anagramCharCount = 0;
        int start = 0;
        HashMap<Character, Integer> stringCount = new HashMap<>();
        while (index < s.length()) {
            char ch = s.charAt(index);
            int currentValue = stringCount.getOrDefault(ch, 0);
            if (currentValue + 1 <= characterCount.getOrDefault(ch, 0))
                anagramCharCount++;
            stringCount.put(ch, currentValue + 1);
            if (index >= p.length()) {
                // window start ko bhi update krna hai
                char chr = s.charAt(start);
                int windowStart = stringCount.getOrDefault(chr, 0);
                if (windowStart - 1 < characterCount.getOrDefault(chr, 0))
                    anagramCharCount--;
                stringCount.put(chr, windowStart - 1);
                start++;
            }
            if (anagramCharCount == p.length())
                ans.add(index - p.length() + 1);
            index++;
        }
        return ans;
    }
}
