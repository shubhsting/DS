import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-eventual-safe-states/description/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                DFS(graph, i, visited);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 2 || visited[i] == 3) {
                ans.add(i);
            }
        }
        return ans;
    }
    // 1 -> visited node
    // 3 - > terminal node
    // 2-> safe node

    public boolean DFS(int[][] graph, int current, int[] visited) {
        if (visited[current] == 1) {
            return false;
        }
        if (visited[current] == 2 || visited[current] == 3) {
            return true;
        }
        if (graph[current].length == 0) {
            visited[current] = 2;
            return true;
        }
        visited[current] = 1;
        boolean isSafe = true;
        for (int neighbour : graph[current]) {
            isSafe = isSafe && DFS(graph, neighbour, visited);
        }
        if (isSafe) {
            visited[current] = 2;
        }
        return isSafe;
    }
}
