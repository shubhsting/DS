import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */
// https://www.lintcode.com/problem/434/
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

class Solution {
    /**
     * @param n:         An integer
     * @param m:         An integer
     * @param operators: an array of point
     * @return: an integer array
     */
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

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        int[] parent = new int[m * n];
        int[] rank = new int[m * n];
        for (int index = 0; index < m * n; index++) {
            parent[index] = index;
            rank[index] = 1;
        }

        int[][] board = new int[n][m];
        int noOfIslands = 0;
        List<Integer> ans = new ArrayList<>();
        UnionFind uf = new UnionFind(parent, rank);
        for (Point point : operators) {
            if (board[point.x][point.y] != 1) {
                noOfIslands = noOfIslands + 1;
                board[point.x][point.y] = 1;
                for (int[] direction : directions) {
                    int xCoordinate = point.x + direction[0];
                    int yCoordinate = point.y + direction[1];
                    if (xCoordinate >= 0 && xCoordinate < n && yCoordinate >= 0 && yCoordinate < m
                            && board[xCoordinate][yCoordinate] == 1) {
                        if (uf.find(m * point.x + point.y) != uf.find(m * xCoordinate + yCoordinate)) {
                            noOfIslands = noOfIslands - 1;
                            uf.union(m * point.x + point.y, m * xCoordinate + yCoordinate);
                        }

                    }
                }
            }
            ans.add(noOfIslands);
        }
        return ans;
    }

}