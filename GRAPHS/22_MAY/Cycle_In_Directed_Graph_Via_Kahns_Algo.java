import java.util.ArrayList;
import java.util.LinkedList;
// Kahns Algo
// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        boolean[] visited = new boolean[V];
        for (int index = 0; index < V; index++) {
            for (int neighbour : adj.get(index)) {
                indegree[neighbour] = indegree[neighbour] + 1;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int index = 0; index < indegree.length; index++) {
            if (indegree[index] == 0) {
                queue.addLast(index);
            }
        }

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.removeFirst();
                for (int neighbour : adj.get(current)) {
                    if (!visited[neighbour]) {
                        indegree[neighbour]--;
                        if (indegree[neighbour] == 0) {
                            queue.addLast(neighbour);
                        }
                    }
                }
            }
        }
        for (int index = 0; index < indegree.length; index++) {
            if (indegree[index] != 0) {
                return true;
            }
        }
        return false;
    }
}