class Solution {
    // Function to arrange all letters of a string in lexicographical
    // order using Counting Sort.
    public static String countSort(String arr) {
        int[] freq = new int[26];
        for (int i = 0; i < arr.length(); i++) {
            freq[arr.charAt(i) - 'a']++;
        }

        for (int i = 1; i < 26; i++) {
            freq[i] += freq[i - 1];
        }

        char[] a = new char[arr.length()];
        for (int i = 0; i < arr.length(); i++) {
            int pos = freq[arr.charAt(i) - 'a'];
            a[pos - 1] = arr.charAt(i);
            freq[arr.charAt(i) - 'a'] = pos - 1;
        }

        return String.valueOf(a);
    }
}
