import java.util.ArrayList;
import java.util.List;

class Solution {
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

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int index = 1; index <= n; index++) {
            parent[index] = index;
            rank[index] = 1;
        }
        UnionFind uf = new UnionFind(parent, rank);
        for (int z = threshold + 1; z <= n; z++) {
            for (int number = z; number <= n; number += z) {
                uf.merge(z, number);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int index = 0; index < queries.length; index++) {
            if (uf.find(queries[index][0]) == uf.find(queries[index][1])) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
