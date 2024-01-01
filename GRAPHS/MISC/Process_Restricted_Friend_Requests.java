package GRAPHS.MISC;

import java.util.HashSet;
// https://leetcode.com/problems/process-restricted-friend-requests/description/

class Solution {

    class UnionFind {
        private int[] parent;
        private HashSet<Integer>[] restrictions;
        private HashSet<Integer> restrictedNodes;

        UnionFind(int[] parent, HashSet<Integer>[] restrictions, HashSet<Integer> restrictedNodes) {
            this.parent = parent;
            this.restrictions = restrictions;
            this.restrictedNodes = restrictedNodes;
        }

        private int find(int point) {
            if (parent[point] == point) {
                return point;
            }
            // path compression
            parent[point] = find(parent[point]);
            return parent[point];

        }

        public boolean union(int point_1, int point_2) {
            int parent_1 = find(point_1);
            int parent_2 = find(point_2);

            if (parent_1 == parent_2) {
                return true;
            }

            if (restrictedNodes.contains(parent_1) && restrictedNodes.contains(parent_2)) {
                if (restrictions[parent_1].contains(parent_2) || restrictions[parent_2].contains(parent_1)) {
                    return false;
                }
                parent[parent_2] = parent_1;
                restrictions[parent_1].addAll(restrictions[parent_2]);
                restrictions[parent_2].addAll(restrictions[parent_1]);
                for (Integer node : restrictions[parent_1]) {
                    restrictions[node].add(parent_1);
                    restrictions[node].add(parent_2);
                }

            } else if (restrictedNodes.contains(parent_1)) {
                parent[parent_2] = parent_1;
            } else if (restrictedNodes.contains(parent_2)) {
                parent[parent_1] = parent_2;
            } else {
                parent[parent_2] = parent_1;
            }
            return true;
        }
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        HashSet<Integer>[] restrictionList = new HashSet[n];
        HashSet<Integer> restrictedNodes = new HashSet<>();

        int[] parent = new int[n];
        for (int index = 0; index < n; index++) {
            restrictionList[index] = new HashSet<>();
            parent[index] = index;
        }
        for (int[] restriction : restrictions) {
            int start = restriction[0];
            int end = restriction[1];
            restrictedNodes.add(start);
            restrictedNodes.add(end);

            restrictionList[start].add(end);
            restrictionList[end].add(start);
        }
        UnionFind uf = new UnionFind(parent, restrictionList, restrictedNodes);

        boolean[] ans = new boolean[requests.length];

        for (int index = 0; index < requests.length; index++) {
            ans[index] = uf.union(requests[index][0], requests[index][1]);
        }
        return ans;
    }
}