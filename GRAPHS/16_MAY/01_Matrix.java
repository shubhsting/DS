import java.util.LinkedList;

class Solution {
    // https://leetcode.com/problems/01-matrix/description/
    class Edge {
        int row;
        int col;
        int distance;

        Edge(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        LinkedList<Edge> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    queue.addLast(new Edge(row, col, 0));
                    visited[row][col] = true;
                }

            }
        }

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.removeFirst();
                int row = current.row;
                int col = current.col;
                mat[row][col] = current.distance;
                if (row + 1 < mat.length && mat[row + 1][col] == 1 && !visited[row + 1][col]) {
                    visited[row + 1][col] = true;
                    queue.addLast(new Edge(row + 1, col, current.distance + 1));
                }
                if (row - 1 >= 0 && mat[row - 1][col] == 1 && !visited[row - 1][col]) {
                    visited[row - 1][col] = true;
                    queue.addLast(new Edge(row - 1, col, current.distance + 1));
                }
                if (col - 1 >= 0 && mat[row][col - 1] == 1 && !visited[row][col - 1]) {
                    visited[row][col - 1] = true;
                    queue.addLast(new Edge(row, col - 1, current.distance + 1));
                }
                if (col + 1 < mat[0].length && mat[row][col + 1] == 1 && !visited[row][col + 1]) {
                    visited[row][col + 1] = true;
                    queue.addLast(new Edge(row, col + 1, current.distance + 1));
                }
            }
        }
        return mat;
    }

}
