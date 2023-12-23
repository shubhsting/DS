import java.util.ArrayList;
// https://www.geeksforgeeks.org/problems/topological-sort/1
class Solution {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        for (int index = 0; index < V; index++) {
            if (!visited[index]) {
                DFS(graph, list, visited, index);
            }
        }
        int[] topologicalOrder = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            topologicalOrder[list.size() - 1 - i] = list.get(i);
        }
        return topologicalOrder;
    }

    static void DFS(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> list, boolean[] visited, int current) {
        visited[current] = true;
        for (Integer neighbour : graph.get(current)) {
            if (!visited[neighbour]) {
                DFS(graph, list, visited, neighbour);
            }
        }
        list.add(current);
    }
}