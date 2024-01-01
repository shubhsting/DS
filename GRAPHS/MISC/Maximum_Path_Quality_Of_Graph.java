package GRAPHS.MISC;

import java.util.ArrayList;
import java.util.HashSet;
// https://leetcode.com/problems/maximum-path-quality-of-a-graph/description/
class Solution {
    class Edge {
        int end;
        int cost;

        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            graph[index] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new Edge(edge[1], edge[2]));
            graph[edge[1]].add(new Edge(edge[0], edge[2]));
        }
        int[] ans = new int[1];

        int[] vis = new int[n];
        DFS(graph, 0, maxTime, 0, ans, values, vis, 0);
        return ans[0];
    }

    public void DFS(ArrayList<Edge>[] graph, int timeSoFar, int maxTime, int current, int[] ans, int[] values,
            int[] visited, int costSoFar) {
        if (timeSoFar > maxTime) {
            return;
        }
        if (visited[current] == 0) {
            costSoFar += values[current];
        }
        if (current == 0) {
            ans[0] = Math.max(ans[0], costSoFar);
        }
        visited[current]++;
        for (Edge neighbour : graph[current]) {
            DFS(graph, timeSoFar + neighbour.cost, maxTime, neighbour.end, ans, values, visited, costSoFar);
        }
        visited[current]--;
        ;
    }
}


class Solution2 {
    class Edge{
        int end;
        int cost;
        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int index = 0; index<n;index++) {
            graph[index] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(new Edge(edge[1], edge[2]));
            graph[edge[1]].add(new Edge(edge[0], edge[2]));
        }
        int[] ans = new int[1];
        DFS(graph, 0, maxTime, 0, "0",ans, values);
        return ans[0];
    }

    public void DFS(ArrayList<Edge>[] graph, int timeSoFar, int maxTime, int current, String pathSoFar, int[] ans, int[] values) {
        
        for(Edge neighbour: graph[current]) {
            if(timeSoFar + neighbour.cost<=maxTime) {
                DFS(graph, timeSoFar + neighbour.cost, maxTime, neighbour.end, pathSoFar + "->" + neighbour.end, ans, values);
            }
        }
        if(current == 0) {
            String[] pathNodes = pathSoFar.split("->");
            HashSet<Integer> set = new HashSet<>();
            for(String node: pathNodes) {
                set.add(Integer.parseInt(node));
            }
            Integer pathAns = 0;
            for(Integer element: set) {
                pathAns+=values[element];
            }
            ans[0] = Math.max(ans[0], pathAns);
        }
    }
}