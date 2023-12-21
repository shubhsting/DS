import java.util.ArrayList;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> topologicalOrder = new Stack<>();
        ArrayList<ArrayList<Integer>> invertedGraph = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for (int index = 0; index < V; index++) {
            if (!visited[index]) {
                DFS(graph, visited, index, topologicalOrder);
            }
            invertedGraph.add(new ArrayList<>());
        }

        for (int index = 0; index < V; index++) {
            for (Integer neighbour : graph.get(index)) {
                invertedGraph.get(neighbour).add(index);
            }
        }

        int count = 0;
        visited = new boolean[V];

        while (!topologicalOrder.isEmpty()) {
            int element = topologicalOrder.pop();
            if (!visited[element]) {
                count = count + 1;
                DFS(invertedGraph, visited, element, null);
            }
        }
        return count;
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
