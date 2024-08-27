//https://leetcode.com/problems/gas-station/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentFuel = 0;
        int startingPoint = 0;
        for (int index = 0; index < gas.length; index++) {
            totalSurplus += gas[index] - cost[index];
            currentFuel += gas[index] - cost[index];
            if (currentFuel < 0) {
                currentFuel = 0;
                startingPoint = index + 1;
            }
        }
        return totalSurplus < 0 ? -1 : startingPoint;
    }
}