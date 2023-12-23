import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/critical-connections-in-a-network/description/
// Articulation Bridge
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        discoveryIndex = 0;
        boolean[] visited = new boolean[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            graph[index] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            int start = edge.get(0);
            int end = edge.get(1);
            graph[start].add(end);
            graph[end].add(start);
        }
        int[] parent = new int[n];
        int[] discovery = new int[n];
        int[] lowest = new int[n];
        Arrays.fill(parent, -1);
        List<List<Integer>> ans = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            if (!visited[index]) {
                DFS(graph, parent, discovery, lowest, visited, index, ans);
            }
        }
        return ans;
    }

    int discoveryIndex;

    public void DFS(ArrayList<Integer>[] graph, int[] parent, int[] discovery, int[] lowest, boolean[] visited,
            int current, List<List<Integer>> ans) {
        visited[current] = true;
        discovery[current] = discoveryIndex;
        lowest[current] = discoveryIndex;
        for (Integer neighbour : graph[current]) {
            if (visited[neighbour] && parent[current] != neighbour) {
                lowest[current] = Math.min(lowest[current], discovery[neighbour]);
            } else if (!visited[neighbour]) {
                discoveryIndex++;
                parent[neighbour] = current;
                DFS(graph, parent, discovery, lowest, visited, neighbour, ans);
                lowest[current] = Math.min(lowest[current], lowest[neighbour]);
                if (lowest[neighbour] > discovery[current]) {
                    ans.add(Arrays.asList(current, neighbour));
                }
            }
        }
    }
}