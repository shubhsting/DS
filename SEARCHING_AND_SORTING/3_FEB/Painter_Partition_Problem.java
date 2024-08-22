

// https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
class Solution {
    static long minTime(int[] arr, int n, int k) {
        return paint(k, 1, arr);
    }

    public static long paint(int noOfPainters, int timeTakenForEachUnit, int[] boards) {
        long low = Integer.MIN_VALUE;
        long high = 0;
        for (int board : boards) {
            high += timeTakenForEachUnit * board;
            low = Math.max(low, board * timeTakenForEachUnit);
        }
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (isPaintingTimeSufficient(mid, boards, noOfPainters, timeTakenForEachUnit)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isPaintingTimeSufficient(long totalPaintingTime, int[] boards, int noOfPainters,
            int timeTakenForEachUnit) {
        int painterRequired = 1;
        long currentPaintingTime = 0;
        for (int board : boards) {
            if (currentPaintingTime + timeTakenForEachUnit * board <= totalPaintingTime) {
                currentPaintingTime += timeTakenForEachUnit * board;
            } else {
                currentPaintingTime = timeTakenForEachUnit * board;
                painterRequired++;
            }
        }
        return painterRequired <= noOfPainters;
    }
}
