import java.util.PriorityQueue;

class Solution {
    // https://leetcode.com/problems/path-with-minimum-effort/description
    class Edge {
        int row;
        int col;
        int maxHeightSoFar;

        Edge(int row, int col, int maxHeightSoFar) {
            this.row = row;
            this.col = col;
            this.maxHeightSoFar = maxHeightSoFar;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        return DIJKSTRA(heights);
    }

    public int DIJKSTRA(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        PriorityQueue<Edge> queue = new PriorityQueue<>((Edge a, Edge b) -> {
            return a.maxHeightSoFar - b.maxHeightSoFar;
        });

        queue.add(new Edge(0, 0, 0));
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.remove();

                int row = current.row;
                int col = current.col;
                if (visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                if (row == heights.length - 1 && col == heights[0].length - 1) {
                    return current.maxHeightSoFar;
                }
                if (row + 1 < heights.length && !visited[row + 1][col]) {
                    queue.add(new Edge(row + 1, col,
                            Math.max(current.maxHeightSoFar, Math.abs(heights[row][col] - heights[row + 1][col]))));
                }
                if (row - 1 >= 0 && !visited[row - 1][col]) {
                    queue.add(new Edge(row - 1, col,
                            Math.max(current.maxHeightSoFar, Math.abs(heights[row][col] - heights[row - 1][col]))));
                }
                if (col + 1 < heights[0].length && !visited[row][col + 1]) {
                    queue.add(new Edge(row, col + 1,
                            Math.max(current.maxHeightSoFar, Math.abs(heights[row][col] - heights[row][col + 1]))));
                }
                if (col - 1 >= 0 && !visited[row][col - 1]) {
                    queue.add(new Edge(row, col - 1,
                            Math.max(current.maxHeightSoFar, Math.abs(heights[row][col] - heights[row][col - 1]))));
                }
            }
        }
        return -1;
    }
}