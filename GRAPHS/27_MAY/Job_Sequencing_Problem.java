import java.util.Arrays;

// Complexity: nlog(n)[sorting] + n*log(no of available days)[logarithm complexity because we didn't use union by rank in union fxn.]
class Solution {
    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    class UnionFind {
        private int[] parent;

        UnionFind(int[] parent) {
            this.parent = parent;
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
                parent[parent_1] = parent_2;
            }
        }
    }

    int[] JobScheduling(Job arr[], int n) {
        int[] parent = new int[n + 1];
        for (int index = 0; index <= n; index++) {
            parent[index] = index;
        }
        UnionFind uf = new UnionFind(parent);

        Arrays.sort(arr, (Job a, Job b) -> {
            return b.profit - a.profit;
        });
        int[] ans = new int[2];
        for (Job job : arr) {
            int emptyIndex = uf.find(job.deadline);
            if (emptyIndex != 0) {
                uf.union(emptyIndex, uf.find(emptyIndex - 1));
                ans[0]++;
                ans[1] += job.profit;
            }
        }
        return ans;
    }
}