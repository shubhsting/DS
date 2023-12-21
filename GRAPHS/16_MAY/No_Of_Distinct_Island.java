import java.util.HashSet;

// https://www.lintcode.com/problem/860/
// https://www.codingninjas.com/studio/problems/distinct-islands_630460
class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] arr) {
        int ans = 0;
        HashSet<String> paths = new HashSet<>();
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] == 1) {
                    String path = dfs(arr, row, col);
                    if (!paths.contains(path)) {
                        ans = ans + 1;
                        paths.add(path);
                    }
                }
            }
        }
        return ans;
    }

    public static String dfs(int[][] arr, int row, int col) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] != 1) {
            return "X";
        }
        arr[row][col] = 0;
        String ans = "";
        ans = ans + "D" + dfs(arr, row + 1, col);
        ans = ans + "U" + dfs(arr, row - 1, col);
        ans = ans + "R" + dfs(arr, row, col + 1);
        ans = ans + "L" + dfs(arr, row, col - 1);

        return ans;
    }
}