class Solution {

    class UnionFind {
        private int[] parent;
        private int[] size;

        UnionFind(int[] parent, int[] size) {
            this.parent = parent;
            this.size = size;
        }

        public int find(int node) {
            if (parent[node] == node) {
                return node;
            }

            parent[node] = find(parent[node]);
            return parent[node];
        }

        public void merge(int node_1, int node_2) {
            int parent_1 = find(node_1);
            int parent_2 = find(node_2);

            if (parent_1 == parent_2) {
                return;
            }
            if (parent_1 == 0) {
                parent[parent_2] = parent_1;
                size[parent_1] += size[parent_2];
            } else {
                parent[parent_1] = parent_2;
                size[parent_2] += size[parent_1];
            }

        }
    }

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int n = grid.length;
        int m = grid[0].length;

        int[] parent = new int[n * m + 1];
        int[] size = new int[n * m + 1];
        for (int index = 0; index <= n * m; index++) {
            parent[index] = index;
            size[index] = 1;
        }
        int[] ans = new int[hits.length];
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = 2;
            } else {
                grid[hit[0]][hit[1]] = -2;
            }

        }
        UnionFind uf = new UnionFind(parent, size);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int element_1 = row * m + col + 1;
                if (row == 0 && grid[row][col] == 1) {
                    uf.merge(0, element_1);
                } else if (grid[row][col] == 1) {
                    for (int[] direction : directions) {
                        int newRow = row + direction[0];
                        int newCol = col + direction[1];
                        int element_2 = newRow * m + newCol + 1;
                        if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1) {
                            uf.merge(element_1, element_2);
                        }
                    }
                }
            }
        }

        for (int index = hits.length - 1; index >= 0; index--) {
            int[] hit = hits[index];
            int element_1 = hit[0] * m + hit[1] + 1;
            if (grid[hit[0]][hit[1]] == 2) {
                grid[hit[0]][hit[1]] = 1;
            } else {
                grid[hit[0]][hit[1]] = 0;
                ans[index] = 0;
                continue;
            }

            int earlierSizeOfStableBricks = size[0];
            // if the added person is in first row, add that to 0 group also.
            if (hit[0] == 0) {
                uf.merge(0, hit[0] * m + hit[1] + 1);
            }
            for (int[] direction : directions) {
                int newRow = hit[0] + direction[0];
                int newCol = hit[1] + direction[1];
                int element_2 = newRow * m + newCol + 1;
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1) {
                    uf.merge(element_1, element_2);
                }
            }
            if (earlierSizeOfStableBricks == size[0]) {
                ans[index] = 0;
            } else {
                ans[index] = size[0] - earlierSizeOfStableBricks - 1;
            }
        }

        return ans;
    }
}