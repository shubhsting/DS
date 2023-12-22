import java.util.LinkedList;

class Solution {
    class Edge {
        int row;
        int col;
        int distance;

        Edge(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int maxDistance(int[][] grid) {
        LinkedList<Edge> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    queue.addLast(new Edge(row, col, 0));
                }
            }
        }
        int ans = -1;
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.removeFirst();
                for (int[] direction : directions) {
                    int row = current.row + direction[0];
                    int col = current.col + direction[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0) {
                        grid[row][col] = current.distance + 1;
                        ans = Math.max(ans, grid[row][col]);
                        queue.addLast(new Edge(row, col, grid[row][col]));
                    }
                }
            }
        }
        return ans;
    }
}