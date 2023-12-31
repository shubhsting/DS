package GRAPHS.MISC;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    class EdgeMetadata {
        int end;
        int costSoFar;

        EdgeMetadata(int end, int costSoFar) {
            this.end = end;
            this.costSoFar = costSoFar;
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            graph[index] = new ArrayList<>();
        }
        for (int index = 0; index < n; index++) {
            if (edges[index] != -1) {
                int start = index;
                int end = edges[index];
                graph[start].add(end);
            }
        }

        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        for (int index = 0; index < n; index++) {
            if (vis[index] == -1) {
                discoveryIndex = 0;
                DFS(graph, vis, ans, index);
            }

        }
        return ans[0] == Integer.MIN_VALUE ? -1 : ans[0];
    }

    int discoveryIndex;

    public void DFS(ArrayList<Integer>[] graph, int[] vis, int[] max, int current) {
        if (graph[current].size() == 0) {
            return;
        }
        vis[current] = discoveryIndex;
        for (Integer neighbour : graph[current]) {
            if (vis[neighbour] == -1) {
                discoveryIndex++;
                DFS(graph, vis, max, neighbour);
            } else if (vis[neighbour] != Integer.MAX_VALUE) {
                max[0] = Math.max(vis[current] - vis[neighbour] + 1, max[0]);
            }
        }
        vis[current] = Integer.MAX_VALUE;
    }
}
