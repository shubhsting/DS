
//https://www.codingninjas.com/studio/problems/connecting-cities-with-minimum-cost_1386586
// https://www.spoj.com/problems/MST/

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    static class Edge {
        int end;
        int cost;

        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static int getMinimumCost(int n, int m, int[][] connections) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] arr : connections) {
            int start = arr[0];
            int end = arr[1];
            int cost = arr[2];
            graph[start].add(new Edge(end, cost));
            graph[end].add(new Edge(start, cost));
        }
        boolean[] visited = new boolean[n + 1];
        int cost = PRIMS(graph, visited, 1);
        for (int index = 1; index < visited.length; index++) {
            if (!visited[index])
                return -1;
        }
        return cost;
    }

    public static int PRIMS(ArrayList<Edge>[] graph, boolean[] visited, int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((Edge a, Edge b) -> {
            return a.cost - b.cost;
        });
        int cost = 0;
        queue.add(new Edge(start, 0));

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.remove();
                if (visited[current.end]) {
                    continue;
                }
                visited[current.end] = true;
                cost += current.cost;
                for (Edge neighbour : graph[current.end]) {
                    if (!visited[neighbour.end]) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return cost;
    }

}