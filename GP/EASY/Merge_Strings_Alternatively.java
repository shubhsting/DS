// https://leetcode.com/problems/merge-strings-alternately/
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int currentIdx = 0;
        StringBuilder sb = new StringBuilder();
        int index1 = 0;
        int index2 = 0;

        while (index1 < word1.length() && index2 < word2.length()) {
            if (currentIdx % 2 == 0) {
                sb.append(word1.charAt(index1));
                index1++;
            } else {
                sb.append(word2.charAt(index2));
                index2++;
            }
            currentIdx++;
        }

        if (index1 < word1.length())
            return sb.toString() + word1.substring(index1, word1.length());
        return sb.toString() + word2.substring(index2, word2.length());
    }
}