// https://www.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
class Solution {
    public int fun(String s) {
        int MOD = 1000000007;
        int countendingA = 0;
        int countendingB = 0;
        int countendingC = 0;

        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (ch == 'a') {
                countendingA = ((2 * countendingA) % MOD + 1) % MOD;
            } else if (ch == 'b') {
                countendingB = ((2 * countendingB) % MOD + countendingA % MOD) % MOD;
            } else if (ch == 'c') {
                countendingC = (countendingB % MOD + (2 * countendingC) % MOD) % MOD;
            }
        }
        return countendingC % MOD;
    }
}