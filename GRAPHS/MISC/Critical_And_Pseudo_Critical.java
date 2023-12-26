package GRAPHS.MISC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {

    class UnionFind {
        private int[] parent;
        private int[] rank;

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

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int index = 0; index < edges.length; index++) {
            int[] edge = edges[index];
            edges[index] = new int[4];
            edges[index][0] = edge[0];
            edges[index][1] = edge[1];
            edges[index][2] = edge[2];
            edges[index][3] = index;
        }
        for (int index = 0; index < n; index++) {
            parent[index] = index;
            rank[index] = 1;
        }
        Arrays.sort(edges, (int[] a, int[] b) -> {
            return a[2] - b[2];
        });
        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();

        int minCost = costViaKruskal(edges, n, -1, -1);

        for (int index = 0; index < edges.length; index++) {
            int costAfterCompulsory = costViaKruskal(edges, n, -1, index);
            int costAfterIgnore = costViaKruskal(edges, n, index, -1);
            // the ordering of conditions is important because critical edge will be
            // satisfying both conditions.
            // if we will ignore it, the cost will increase, if we will compulsorily add it
            // cost will be equal. Hence we need to first check ignore case
            if (costAfterIgnore > minCost) { // if we ignore the edge, it will result in greater cost
                criticalEdges.add(edges[index][3]);
            } else if (costAfterCompulsory == minCost) { // if we ignore the edge, it will not impact mst cost
                pseudoCriticalEdges.add(edges[index][3]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(criticalEdges);
        ans.add(pseudoCriticalEdges);
        return ans;
    }

    public int costViaKruskal(int[][] edges, int n, int ignoreIndex, int compulsoryIndex) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        UnionFind uf = new UnionFind(parent, rank);
        int minCost = 0;
        for (int index = 0; index < n; index++) {
            parent[index] = index;
            rank[index] = 1;
        }
        if (compulsoryIndex != -1) {
            uf.merge(edges[compulsoryIndex][0], edges[compulsoryIndex][1]);
            minCost += edges[compulsoryIndex][2];
        }

        for (int index = 0; index < edges.length; index++) {
            int[] edge = edges[index];
            if (index == ignoreIndex) {
                continue;
            }
            if (uf.find(edge[0]) != uf.find(edge[1])) {
                uf.merge(edge[0], edge[1]);
                minCost += edge[2];
            }
        }

        for (int index = 0; index < n; index++) {
            if (uf.find(index) != uf.find(0))
                return Integer.MAX_VALUE;
        }
        return minCost;
    }
}