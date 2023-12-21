import java.util.PriorityQueue;
import java.util.ArrayList;

//https://www.codingninjas.com/studio/problems/water-supply-in-a-village_1380956
class Solution {
    static class Edge {
        int end;
        int cost;

        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static int supplyWater(int n, int k, int[] wells, int[][] pipes) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : pipes) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];
            graph[start].add(new Edge(end, cost));
            graph[end].add(new Edge(start, cost));
        }
        for (int index = 0; index < wells.length; index++) {
            graph[0].add(new Edge(index + 1, wells[index]));
            graph[index + 1].add(new Edge(0, wells[index]));
        }
        return PRIMS(graph, n);
    }

    public static int PRIMS(ArrayList<Edge>[] graph, int n) {
        boolean[] vis = new boolean[n + 1];
        int cost = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>((Edge a, Edge b) -> {
            return a.cost - b.cost;
        });

        queue.add(new Edge(0, 0));
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.remove();
                if (vis[current.end]) {
                    continue;
                }
                vis[current.end] = true;
                cost += current.cost;
                for (Edge neighbour : graph[current.end]) {
                    if (!vis[neighbour.end]) {
                        queue.add(neighbour);
                    }

                }
            }
        }
        return cost;
    }
}