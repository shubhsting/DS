//https://www.geeksforgeeks.org/problems/digit-multiplier3000/1
class Solution {
    static String getSmallest(Long N) {
        if (N == 1 || N == 0) {
            return N == 0 ? "-1" : N + "";
        }
        int n = 9;
        String ans = "";
        while (N > 0 && n > 1) {
            if (N % n == 0) {
                ans = n + ans;
                N = N / n;
            } else {
                n--;
            }
        }
        return N == 1 ? ans : "-1";
    }
};
