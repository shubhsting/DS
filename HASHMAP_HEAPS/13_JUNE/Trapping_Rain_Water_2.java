//https://leetcode.com/problems/trapping-rain-water-ii/description/
class Solution {
    class Edge {
        int row;
        int column;
        int value;

        Edge(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((Edge a, Edge b) -> {
            return a.value - b.value;
        });
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                if (row == 0 || column == 0 || row == n - 1 || column == m - 1) {
                    pq.add(new Edge(row, column, heightMap[row][column]));
                    visited[row][column] = true;
                }
            }
        }

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int ans = 0;
        while (pq.size() != 0) {
            Edge node = pq.remove();
            for (int[] direction : directions) {
                int r = node.row + direction[0];
                int c = node.column + direction[1];
                if (r >= 0 && c >= 0 && r < n && c < m && !visited[r][c]) {
                    if (heightMap[r][c] <= node.value) {
                        ans += node.value - heightMap[r][c];
                        visited[r][c] = true;
                        pq.add(new Edge(r, c, node.value));
                    } else {
                        visited[r][c] = true;
                        pq.add(new Edge(r, c, heightMap[r][c]));
                    }
                }
            }
        }
        return ans;
    }
}
