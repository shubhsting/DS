import java.util.LinkedList;
// https://www.lintcode.com/problem/803/description
class Solution {
    /**
     * @param grid: the 2D grid
     * @return: the shortest distance
     */
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

    public int shortestDistance(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int noOfBuildings = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    noOfBuildings += 1;
                }
            }
        }
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    int currentCost = BFS(grid, new boolean[grid.length][grid[0].length], row, col, noOfBuildings);
                    ans = currentCost == -1 ? ans : Math.min(ans, currentCost);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int BFS(int[][] grid, boolean[][] visited, int row, int col, int noOfBuildings) {
        LinkedList<Edge> queue = new LinkedList<>();
        int distance = -1;
        visited[row][col] = true;
        queue.addLast(new Edge(row, col, 0));
        int encounteredBuildings = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.removeFirst();
                if (grid[current.row][current.col] == 1) {
                    encounteredBuildings++;
                    distance = (distance == -1) ? current.distance : distance + current.distance;
                    continue;
                }

                for (int[] direction : directions) {
                    int r = current.row + direction[0];
                    int c = current.col + direction[1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !visited[r][c]
                            && grid[r][c] != 2) {
                        visited[r][c] = true;
                        queue.addLast(new Edge(r, c, current.distance + 1));
                    }
                }
            }
        }

        return noOfBuildings == encounteredBuildings ? distance : -1;
    }

}
