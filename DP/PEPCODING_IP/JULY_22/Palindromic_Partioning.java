package DP.PEPCODING_IP.JULY_22;

// https://leetcode.com/problems/palindrome-partitioning-ii/description/
class Solution {
    public int minCut(String s) {
        // HashSet<String> palindromes = new HashSet<>();
        // if(isPalindrome(s, palindromes)) {
        // return 0;
        // }

        // int[][] dp = new int[s.length() + 1][s.length() + 1];
        // for(int[] ar: dp) {
        // Arrays.fill(ar, -1);
        // }
        return MCM_Top_Down(s, 0, s.length() - 1);
    }

    // normal GFG working code
    public int MCM(String s, int start, int end, int[][] dp, HashSet<String> palindromes) {
        if (start > end) {
            return 0;
        }
        if ((start == end) || (isPalindrome(s, palindromes))) {
            return dp[start][end] = 1;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        String temp = "";
        int ans = Integer.MAX_VALUE;
        for (int index = start; index <= end; index++) {
            if (isPalindrome(s.substring(start, index + 1), palindromes)) {
                ans = Math.min(ans, 1 + MCM(s, index + 1, end, dp, palindromes));
            }
        }
        return dp[start][end] = ans;
    }

    // leetcode memoisation
    public int MCM_Top_Down(String s, int start, int end) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        boolean[][] dp_palindrome = new boolean[s.length()][s.length()];
        for (int gap = 0; gap < s.length(); gap++) {
            for (int row = 0; row < s.length() - gap; row++) {
                int column = row + gap;
                if (gap == 0) {
                    dp[row][column] = 1;
                    dp_palindrome[row][column] = true;
                    continue;
                }
                if (gap == 1) {
                    dp_palindrome[row][column] = (s.charAt(row) == s.charAt(column));
                } else {
                    dp_palindrome[row][column] = (s.charAt(row) == s.charAt(column)
                            && dp_palindrome[row + 1][column - 1]);
                }
                if (dp_palindrome[row][column]) {
                    dp[row][column] = 1;
                    continue;
                }
                int ans = Integer.MAX_VALUE;
                for (int index = row; index <= column; index++) {
                    if (dp_palindrome[row][index]) {
                        ans = Math.min(ans, 1 + dp[index + 1][column]);
                    }
                }
                dp[row][column] = ans;
            }
        }
        return dp[0][s.length() - 1] - 1;
    }

    public boolean isPalindrome(String s, HashSet<String> palindromes) {
        if (palindromes.contains(s)) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        palindromes.add(s);
        return true;
    }
}
