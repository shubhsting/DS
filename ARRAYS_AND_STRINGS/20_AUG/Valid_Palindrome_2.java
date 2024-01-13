class Solution {
    public boolean validPalindrome(String s) {
        return palindrome(s, 0, s.length() - 1, false);
    }

    public boolean palindrome(String str, int start, int end, boolean inverted) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) == str.charAt(end)) {
            return palindrome(str, start + 1, end - 1, inverted);
        } else {
            if (inverted) {
                return false;
            } else {
                return palindrome(str, start + 1, end, true) || palindrome(str, start, end - 1, true);
            }

        }
    }
}
