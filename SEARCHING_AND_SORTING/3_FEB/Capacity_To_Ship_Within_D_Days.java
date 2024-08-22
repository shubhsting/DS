// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int weight : weights) {
            low = Math.max(weight, low);
            high += weight;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isCapacityWithinDays(mid, days, weights)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isCapacityWithinDays(int capacity, int days, int[] weights) {
        int currentBeltLoad = 0;
        int noOfDays = 1;
        for (int weight : weights) {
            if (currentBeltLoad + weight <= capacity) {
                currentBeltLoad += weight;
            } else {
                currentBeltLoad = weight;
                noOfDays++;
            }
        }
        return noOfDays <= days;
    }
}
