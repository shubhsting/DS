import java.util.Arrays;
import java.util.HashSet;
// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!vowels.contains(arr[start])) {
                start++;
            }
            if (!vowels.contains(arr[end])) {
                end--;
            }

            if (vowels.contains(arr[end]) && vowels.contains(arr[start])) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        return String.valueOf(arr);
    }
}
