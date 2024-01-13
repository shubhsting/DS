class Solution {
    // https://leetcode.com/problems/maximum-swap/description/
    public int maximumSwap(int num) {
        String stringNo = Integer.toString(num);
        int[] lastOccurance = new int[10];
        for (int index = 0; index < stringNo.length(); index++) {
            lastOccurance[stringNo.charAt(index) - '0'] = index;
        }
        char[] ans = stringNo.toCharArray();
        for (int index = 0; index < stringNo.length(); index++) {
            int number = stringNo.charAt(index) - '0';
            int nextGreaterIndex = findGreaterNo(lastOccurance, number, index);
            if (nextGreaterIndex != -1) {
                char temp = ans[index];
                ans[index] = ans[nextGreaterIndex];
                ans[nextGreaterIndex] = temp;
                return Integer.valueOf(String.valueOf(ans));
            }

        }

        return Integer.parseInt(stringNo);
    }

    public int findGreaterNo(int[] lastOccurance, int no, int currentIndex) {
        int current = 9;
        while (no < current && current > 0) {
            if (lastOccurance[current] != 0 && lastOccurance[current] > currentIndex) {
                return lastOccurance[current];
            }
            current--;
        }
        return -1;
    }
}
