import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    class EdgeMetadata {
        int end;
        int costSoFar;

        EdgeMetadata(int end, int costSoFar) {
            this.end = end;
            this.costSoFar = costSoFar;
        }
    }

    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            graph[index] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        int ans = Integer.MAX_VALUE;
        for (int index = 0; index < n; index++) {
            int loopSize = Dijkstra(graph, new int[n], index, n);
            ans = Math.min(ans, loopSize);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int Dijkstra(ArrayList<Integer>[] graph, int[] visited, int src, int n) {
        LinkedList<EdgeMetadata> queue = new LinkedList<>();
        queue.addLast(new EdgeMetadata(src, 1));
        int[] parent = new int[n];
        Arrays.fill(visited, -1);
        visited[src] = 1;
        int ans = Integer.MAX_VALUE;
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                EdgeMetadata current = queue.removeFirst();
                for (Integer neighbour : graph[current.end]) {
                    if (visited[neighbour] == -1) {
                        parent[neighbour] = current.end;
                        visited[neighbour] = current.costSoFar + 1;
                        queue.addLast(new EdgeMetadata(neighbour, current.costSoFar + 1));
                    } else if (parent[current.end] != neighbour) {
                        ans = Math.min(ans, current.costSoFar + visited[neighbour] - 1);
                    }
                }
            }
        }

        return ans;
    }
}