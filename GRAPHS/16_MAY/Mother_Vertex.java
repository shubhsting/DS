import java.util.ArrayList;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/mother-vertex/1
class Solution {
    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < V; index++) {
            if (!visited[index]) {
                DFS(graph, visited, index, stack);
            }
        }
        visited = new boolean[V];
        Integer motherVertex = stack.pop();
        DFS(graph, visited, motherVertex, null);

        for (boolean isNodeVisited : visited) {
            if (!isNodeVisited) {
                return -1;
            }
        }
        return motherVertex;
    }

    public void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int current, Stack stack) {
        visited[current] = true;
        for (Integer neighbour : graph.get(current)) {
            if (!visited[neighbour]) {
                DFS(graph, visited, neighbour, stack);
            }
        }
        if (stack != null) {
            stack.push(current);
        }
    }
}