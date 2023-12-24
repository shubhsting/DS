class Solution {
    class UnionFind {
        private int[] parent;
        private int[] rank;

        UnionFind(int[] parent, int[] rank) {
            this.parent = parent;
            this.rank = rank;
        }

        private int find(int point) {
            if (parent[point] == point) {
                return point;
            }
            // path compression
            parent[point] = find(parent[point]);
            return parent[point];

        }

        public void union(int point_1, int point_2) {
            int parent_1 = find(point_1);
            int parent_2 = find(point_2);
            if (parent_1 != parent_2) {
                // union by rank
                if (rank[parent_1] > rank[parent_2]) {
                    parent[parent_2] = parent_1;
                } else if (rank[parent_2] > rank[parent_1]) {
                    parent[parent_1] = parent_2;
                } else {
                    parent[parent_1] = parent_2;
                    rank[parent_2]++;
                }
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int index = 0; index < edges.length + 1; index++) {
            parent[index] = index;
            rank[index] = 1;
        }

        UnionFind uf = new UnionFind(parent, rank);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) != uf.find(edge[1])) {
                uf.union(edge[0], edge[1]);
            } else {
                return edge;
            }
        }
        return new int[2];
    }
}