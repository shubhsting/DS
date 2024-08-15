class Solution1 {
    // https://leetcode.com/problems/maximize-distance-to-closest-person/
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] preDistance = new int[n];
        int postDistance = 0;
        preDistance[0] = 0;
        for (int index = 1; index < n; index++) {
            if (seats[index] == 1) {
                preDistance[index] = 0;
            } else {
                preDistance[index] = preDistance[index - 1] + 1;
            }
        }

        int ans = preDistance[n - 1];

        for (int index = n - 1; index >= 0; index--) {
            if (seats[index] == 1) {
                postDistance = 0;
            } else {
                postDistance = postDistance + 1;
                ans = Math.max(ans, Math.min(preDistance[index], postDistance));
            }
        }
        return Math.max(ans, postDistance);
    }
}
