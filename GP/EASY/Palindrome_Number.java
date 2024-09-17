// https://leetcode.com/problems/palindrome-number/description/
class Solution {
    public boolean isPalindrome(int x) {
        int number = 0;
        int multiplier = 10;
        int temp = Math.abs(x);
        while (temp != 0) {
            int digit = temp % 10;
            number = number * 10 + digit;
            temp = temp / 10;
        }
        return x == number;
    }
}