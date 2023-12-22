import java.util.LinkedList;

class Solution {
    class Edge {
        int row;
        int col;
        int timeElapsed;

        Edge(int row, int col, int timeElapsed) {
            this.row = row;
            this.col = col;
            this.timeElapsed = timeElapsed;
        }
    }

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        LinkedList<Edge> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.addLast(new Edge(row, col, 0));
                }
            }
        }
        int timeElapsed = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.removeFirst();
                timeElapsed = Math.max(timeElapsed, current.timeElapsed);
                for (int[] direction : directions) {
                    int row = current.row + direction[0];
                    int col = current.col + direction[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.addLast(new Edge(row, col, current.timeElapsed + 1));
                    }
                }
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        return timeElapsed;
    }
}