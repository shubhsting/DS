import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    // https://practice.geeksforgeeks.org/problems/find-the-maximum-flow2126/1
    // Complexity: O(V+E)[1 dfs] * (V*E)[DFS finds incresing order length paths...so it will give first 2
    //  length, then 3 then 4...so there can be V-1 length paths with every K length path having E-K edges..
    // hence  complexity is  E*V]
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        int[][] graph = new int[N + 1][N + 1];
        for (ArrayList<Integer> edge : Edges) {
            int start = edge.get(0);
            int end = edge.get(1);
            int weight = edge.get(2);
            graph[start][end] += weight;
            graph[end][start] += weight;
        }
        int[] path = BFS_EDMOND_KARP(N, graph); // find one possible path using BFS
        int ans = 0;
        while (path[N] != -1) {
            int currentPathMin = Integer.MAX_VALUE;
            int currentNode = N;
            // this loop will find minimum of all the edges in current path
            while (currentNode != 1) {
                int start = path[currentNode];
                currentPathMin = Math.min(currentPathMin, graph[start][currentNode]);
                currentNode = start;
            }
            // add that minimum into ans for this path
            ans += currentPathMin;

            currentNode = N;
            // we will now subtract the minimum from all edges along with adding a backedge of same quantity
            while (currentNode != 1) {
                int start = path[currentNode];
                graph[start][currentNode] -= currentPathMin;
                graph[currentNode][start] += currentPathMin;
                currentNode = start;
            }
            // again fire DFS to update the new path
            path = BFS_EDMOND_KARP(N, graph);
        }

        return ans;

    }

    public int[] BFS_EDMOND_KARP(int N, int[][] graph) {
        int[] path = new int[N + 1];
        Arrays.fill(path, -1);

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.addLast(1);
        visited[1] = true;

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.removeFirst();
                if (current == N) {
                    return path;
                }
                for (int index = 1; index <= N; index++) {
                    if (!visited[index] && graph[current][index] > 0) {
                        queue.addLast(index);
                        visited[index] = true;
                        path[index] = current;
                    }
                }
            }
        }
        return path;
    }
}
