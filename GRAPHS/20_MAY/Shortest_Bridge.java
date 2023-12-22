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

    public int shortestBridge(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        LinkedList<Edge> queue = new LinkedList<>();
        myBreakLabel: 
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    DFS(grid, visited, row, col, queue);
                    break myBreakLabel;
                }
            }
        }
        return BFS(grid, visited, queue);

    }

    public int BFS(int[][] grid, boolean[][] visited, LinkedList<Edge> queue) {
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.removeFirst();
                int row = current.row;
                int col = current.col;
                if (grid[row][col] == 1) {
                    return current.distance - 1;
                }
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newColumn = col + direction[1];
                    if (newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length
                            && !visited[newRow][newColumn]) {
                        visited[newRow][newColumn] = true;
                        queue.addLast(new Edge(newRow, newColumn, current.distance + 1));
                    }
                }
            }
        }
        return -1;
    }

    public void DFS(int[][] grid, boolean[][] visited, int row, int col, LinkedList<Edge> queue) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1
                || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        grid[row][col] = 0;
        queue.addLast(new Edge(row, col, 0));

        for (int[] direction : directions) {
            DFS(grid, visited, row + direction[0], col + direction[1], queue);
        }
    }
}