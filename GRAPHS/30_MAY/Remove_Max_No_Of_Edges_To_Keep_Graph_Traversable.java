class Solution {
    // https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/
    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int[] parent, int[] rank) {
            this.parent = parent;
            this.rank = rank;
        }

        public int find(int element) {
            if (parent[element] == element) {
                return element;
            }

            parent[element] = find(parent[element]);
            return parent[element];
        }

        public void merge(int element_1, int element_2) {
            int parent_1 = find(element_1);
            int parent_2 = find(element_2);

            if (parent_1 == parent_2) {
                return;
            }

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

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parent_alice = new int[n + 1];
        int[] rank_alice = new int[n + 1];

        int[] parent_bob = new int[n + 1];
        int[] rank_bob = new int[n + 1];
        for (int index = 1; index <= n; index++) {
            parent_alice[index] = index;
            rank_alice[index] = 1;
            parent_bob[index] = index;
            rank_bob[index] = 1;
        }
        UnionFind uf_alice = new UnionFind(parent_alice, rank_alice);
        UnionFind uf_bob = new UnionFind(parent_bob, rank_bob);

        int count = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (uf_alice.find(edge[1]) != uf_alice.find(edge[2])) {
                    uf_alice.merge(edge[1], edge[2]);
                    uf_bob.merge(edge[1], edge[2]);
                } else {
                    count = count + 1;
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (uf_alice.find(edge[1]) != uf_alice.find(edge[2])) {
                    uf_alice.merge(edge[1], edge[2]);
                } else {
                    count = count + 1;
                }
            } else if (edge[0] == 2) {
                if (uf_bob.find(edge[1]) != uf_bob.find(edge[2])) {
                    uf_bob.merge(edge[1], edge[2]);
                } else {
                    count = count + 1;
                }
            }
        }

        int countNoOfParentsAlice = 0;
        int countNoOfParentsBob = 0;
        for (int index = 1; index <= n; index++) {
            if (parent_bob[index] == index) {
                countNoOfParentsBob++;
            }
            if (parent_alice[index] == index) {
                countNoOfParentsAlice++;
            }
        }
        return countNoOfParentsAlice == 1 && countNoOfParentsBob == 1 ? count : -1;
    }
}
