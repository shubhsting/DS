class Solution {
    // https://leetcode.com/problems/reach-a-number/
    public int reachNumber(int target) {
        int moveLength = 1;
        int noOfMoves = 0;
        int start = 0;
        while (Math.abs(start) < Math.abs(target)) {
            start = start + moveLength;
            moveLength++;
            noOfMoves++;
        }

        if (start == target || (target - start) % 2 == 0) {
            return noOfMoves;
        }

        while ((start - target) % 2 != 0) {
            start = start + moveLength;
            moveLength++;
            noOfMoves++;
        }
        return noOfMoves;
    }
}
