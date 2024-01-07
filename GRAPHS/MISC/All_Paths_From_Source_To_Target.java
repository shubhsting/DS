package GRAPHS.MISC;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/all-paths-from-source-to-target/description/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(graph, new boolean[graph.length], ans, new ArrayList<>(), 0);
        return ans;
    }

    public void DFS(int[][] graph, boolean[] visited, List<List<Integer>> ans, List<Integer> pathSoFar, int current) {
        if (visited[current]) {
            return;
        }
        if (current == graph.length - 1) {
            pathSoFar.add(current);
            ans.add(new ArrayList<>(pathSoFar));
            pathSoFar.remove(pathSoFar.size() - 1);
            return;
        }

        visited[current] = true;
        pathSoFar.add(current);
        for (int neighbour : graph[current]) {
            DFS(graph, visited, ans, pathSoFar, neighbour);
        }
        pathSoFar.remove(pathSoFar.size() - 1);
        visited[current] = false;
    }
}

class Solution2 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pathSoFar = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        pathSoFar.add(0);
        visited[0] = true;
        DFS(graph, visited, ans, pathSoFar, 0);
        return ans;
    }

    public void DFS(int[][] graph, boolean[] visited, List<List<Integer>> ans, List<Integer> pathSoFar, int current) {

        if (current == graph.length - 1) {
            ans.add(new ArrayList<>(pathSoFar));
            return;
        }

        for (int neighbour : graph[current]) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                pathSoFar.add(neighbour);
                DFS(graph, visited, ans, pathSoFar, neighbour);
                pathSoFar.remove(pathSoFar.size() - 1);
                visited[neighbour] = false;
            }

        }

    }
}