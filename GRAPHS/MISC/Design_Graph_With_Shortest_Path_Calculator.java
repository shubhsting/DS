package GRAPHS.MISC;
// https://leetcode.com/problems/design-graph-with-shortest-path-calculator/description/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

class Graph {
    class Edge {
        int end;
        int cost;

        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    ArrayList<Edge>[] graph;

    public Graph(int n, int[][] edges) {
        graph = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            graph[index] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new Edge(edge[1], edge[2]));
        }
    }

    public void addEdge(int[] edge) {
        graph[edge[0]].add(new Edge(edge[1], edge[2]));
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((Edge a, Edge b) -> {
            return a.cost - b.cost;
        });
        HashSet<Integer> visited = new HashSet<>();
        queue.add(new Edge(node1, 0));

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.remove();
                if (visited.contains(current.end)) {
                    continue;
                }
                if (current.end == node2) {
                    return current.cost;
                }
                visited.add(current.end);

                for (Edge neighbour : graph[current.end]) {
                    if (!visited.contains(neighbour.end)) {
                        queue.add(new Edge(neighbour.end, current.cost + neighbour.cost));
                    }
                }
            }
        }
        return -1;
    }
}