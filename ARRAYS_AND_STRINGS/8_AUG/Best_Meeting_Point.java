import java.util.ArrayList;
// https://www.lintcode.com/problem/912/
class Solution {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> medianElements = new ArrayList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    medianElements.add(row);
                }

            }
        }
        int ansRow = findMedian(medianElements);
        medianElements = new ArrayList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    medianElements.add(col);
                }
            }
        }
        int ansCol = findMedian(medianElements);
        int ans = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    ans += Math.abs(ansRow - row) + Math.abs(ansCol - col);
                }

            }
        }
        return ans;
    }

    public int findMedian(ArrayList<Integer> medianElements) {
        int noOfElements = medianElements.size();
        if (noOfElements % 2 != 0) {
            return medianElements.get(Math.round(noOfElements / 2));
        }
        return medianElements.get(noOfElements / 2);

    }
}
