// https://leetcode.com/problems/number-of-digit-one/description/
class Solution {
    public int countDigitOne(int n) {
        // int ans = 0;
        int placeValue = 1;
        int ans = 0;
        String number = n + "";
        for (int index = number.length() - 1; index >= 0; index--) {
            int no = number.charAt(index) - '0';
            int prefixNo = n / (placeValue * 10);
            int suffixNo = n % placeValue;
            if (no > 1) {
                ans = ans + (prefixNo + 1) * placeValue;
            } else if (no == 1) {
                ans = ans + prefixNo * placeValue + suffixNo + 1;
            } else {
                ans = ans + placeValue * prefixNo;
            }
            placeValue = placeValue * 10;
        }
        return ans;
    }
}