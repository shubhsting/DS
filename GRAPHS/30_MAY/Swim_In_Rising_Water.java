import java.util.PriorityQueue;
// https://leetcode.com/problems/swim-in-rising-water/description/
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

    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int swimInWater(int[][] grid) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((Edge a, Edge b) -> {
            return a.timeElapsed - b.timeElapsed;
        });
        queue.add(new Edge(0, 0, grid[0][0]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.remove();
                if (visited[current.row][current.col]) {
                    continue;
                }
                if (current.row == grid.length - 1 && current.col == grid[0].length - 1) {
                    return current.timeElapsed;
                }
                visited[current.row][current.col] = true;
                for (int[] direction : directions) {
                    int newRow = current.row + direction[0];
                    int newCol = current.col + direction[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                            && !visited[newRow][newCol]) {
                        queue.add(new Edge(newRow, newCol, Math.max(current.timeElapsed, grid[newRow][newCol])));
                    }
                }
            }
        }
        return -1;
    }

}
