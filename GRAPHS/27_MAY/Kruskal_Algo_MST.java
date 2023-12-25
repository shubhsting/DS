import java.util.ArrayList;
// https://www.codingninjas.com/studio/problems/minimum-spanning-tree_631769?leftPanelTabValue=SUBMISSION
class Solution {
    // O(ElogE)(sorting) + O(E)(DSU)
    static class UnionFind {
        private static int[] parent;
        private static int[] rank;

        UnionFind(int[] parent, int[] rank) {
            this.parent = parent;
            this.rank = rank;
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

            if (rank[parent_1] > rank[parent_2]) {
                parent[parent_2] = parent_1;
            } else if (rank[parent_2] > rank[parent_1]) {
                parent[parent_1] = parent_2;
            } else {
                parent[parent_2] = parent_1;
                rank[parent_1]++;
            }
        }
    }

    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {

        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int index = 0; index < n; index++) {
            parent[index] = index;
            rank[index] = 1;
        }
        UnionFind uf = new UnionFind(parent, rank);
        int cost = 0;

        edges.sort((ArrayList<Integer> a, ArrayList<Integer> b) -> {
            return a.get(2) - b.get(2);
        });

        for (ArrayList<Integer> edge : edges) {
            int start = edge.get(0);
            int end = edge.get(1);
            int edge_cost = edge.get(2);

            if (uf.find(start) != uf.find(end)) {
                uf.merge(start, end);
                cost += edge_cost;
            }
        }
        return cost;
    }
}