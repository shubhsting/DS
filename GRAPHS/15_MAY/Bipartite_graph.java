import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    // https://leetcode.com/problems/is-graph-bipartite/
    class EdgeMetadata {
        int end;
        int color;

        EdgeMetadata(int end, int color) {
            this.end = end;
            this.color = color;
        }
    }

    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length + 1];
        Arrays.fill(visited, -1);
        boolean isBipartite = true;
        for (int index = 0; index < graph.length; index++) {
            if (visited[index] == -1) {
                isBipartite = isBipartite && BFS(graph, visited, index);
            }
        }
        return isBipartite;
    }

    public boolean BFS(int[][] graph, int[] visited, int start) {
        LinkedList<EdgeMetadata> queue = new LinkedList<>();
        queue.addLast(new EdgeMetadata(start, 0));
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                EdgeMetadata currentEdge = queue.removeFirst();
                if (visited[currentEdge.end] != -1 && visited[currentEdge.end] != currentEdge.color) {
                    return false;
                }
                visited[currentEdge.end] = currentEdge.color;

                for (int neighbour : graph[currentEdge.end]) {
                    if (visited[neighbour] == -1) {
                        queue.addLast(new EdgeMetadata(neighbour, (currentEdge.color + 1) % 2));
                    }
                }
            }
        }
        return true;
    }
}