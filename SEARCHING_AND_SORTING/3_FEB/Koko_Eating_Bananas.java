// https://leetcode.com/problems/koko-eating-bananas/description/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isKokoSpeedWithinHourLimit(mid, piles, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isKokoSpeedWithinHourLimit(int limitPerHour, int[] piles, int totalHours) {
        int hoursTaken = 0;
        for (int pile : piles) {
            int h = (int) Math.ceil((double) pile / limitPerHour);
            hoursTaken += h;
        }
        return hoursTaken <= totalHours;
    }

}