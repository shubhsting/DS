import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    class Edge {
        StringBuilder state;
        int movesCount;

        Edge(StringBuilder state, int movesCount) {
            this.state = state;
            this.movesCount = movesCount;
        }
    }

    int[][] directions = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

    public int slidingPuzzle(int[][] board) {
        LinkedList<Edge> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                sb.append(board[row][col]);
            }
        }
        queue.addLast(new Edge(sb, 0));
        visited.add(sb.toString());
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.removeFirst();
                int zeroIndex = current.state.indexOf("0");
                String currentString = current.state.toString();
                if (currentString.equals("123450")) {
                    return current.movesCount;
                }
                for (int index : directions[zeroIndex]) {
                    StringBuilder neighbour = new StringBuilder(currentString);
                    neighbour.setCharAt(zeroIndex, currentString.charAt(index));
                    neighbour.setCharAt(index, '0');
                    if (!visited.contains(neighbour.toString())) {
                        visited.add(neighbour.toString());
                        queue.addLast(new Edge(neighbour, current.movesCount + 1));
                    }
                }
            }
        }
        return -1;
    }
}