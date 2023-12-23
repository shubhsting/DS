import java.util.ArrayList;
import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/doctor-strange2206/1
// articulation point 
class Complete {

    // Function for finding maximum and value pair
    public static int doctorStrange(int n, int k, int edges[][]) {
        graph = new ArrayList[n + 1];

        for (int index = 1; index <= n; index++) {
            graph[index] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        discoveryOrder = 0;
        parent = new int[n + 1];
        lowest = new int[n + 1];
        discovery = new int[n + 1];
        int count = 0;
        articulationPoints = new boolean[n + 1];
        Arrays.fill(parent, -1);
        visited = new boolean[n + 1];
        for (int index = 1; index <= n; index++) {
            if (!visited[index]) {
                discoveryOrder = 0;
                DFS(index);
            }
        }
        for (int index = 1; index <= n; index++) {
            if (articulationPoints[index]) {
                count++;
            }
        }
        return count;
    }

    static int discoveryOrder;
    static int[] parent;
    static int[] discovery;
    static ArrayList<Integer>[] graph;
    static int[] lowest;
    static boolean[] visited;
    static boolean[] articulationPoints;

    public static void DFS(int current) {
        visited[current] = true;
        int children = 0;
        discovery[current] = discoveryOrder;
        lowest[current] = discoveryOrder;
        for (Integer neighbour : graph[current]) {
            if (visited[neighbour] && current != parent[neighbour]) {
                lowest[current] = Math.min(lowest[current], discovery[neighbour]);
            } else if (!visited[neighbour]) {
                discoveryOrder++;
                children++;
                parent[neighbour] = current;
                DFS(neighbour);
                lowest[current] = Math.min(lowest[current], lowest[neighbour]);
                if (lowest[neighbour] >= discovery[current] && parent[current] != -1) {
                    articulationPoints[current] = true;
                }
            }
        }
        if (children > 1 && parent[current] == -1) {
            articulationPoints[current] = true;
        }
    }
}