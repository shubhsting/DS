import java.util.Arrays;
import java.util.LinkedList;
// https://practice.geeksforgeeks.org/problems/maximum-bipartite-matching/1
class Solution {
    public int maximumMatch(int[][] connection) {

        int noOfApplicants = connection.length;
        int noOfJobs = connection[0].length;
        int N = noOfApplicants + noOfJobs + 2;
        int[][] graph = new int[N][N];
        for (int applicant = 0; applicant < noOfApplicants; applicant++) {
            for (int job = 0; job < noOfJobs; job++) {
                if (connection[applicant][job] == 1) {
                    int start = applicant + 1;
                    int end = noOfApplicants + job + 1;
                    graph[start][end] = 1;
                    graph[0][start] = 1;
                    graph[end][N - 1] = 1;
                }
            }
        }

        int[] path = BFS_EDMOND_KARP(N, graph); // find one possible path using BFS
        int ans = 0;
        while (path[N - 1] != -1) {
            int currentPathMin = Integer.MAX_VALUE;
            int currentNode = N - 1;
            // this loop will find minimum of all the edges in current path
            while (currentNode != 0) {
                int start = path[currentNode];
                currentPathMin = Math.min(currentPathMin, graph[start][currentNode]);
                currentNode = start;
            }
            // add that minimum into ans for this path
            ans += currentPathMin;

            currentNode = N - 1;
            // we will now subtract the minimum from all edges along with adding a backedge
            // of same quantity
            while (currentNode != 0) {
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
        int[] path = new int[N];
        Arrays.fill(path, -1);

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.addLast(0);
        visited[0] = true;

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.removeFirst();
                if (current == N - 1) {
                    return path;
                }
                for (int index = 0; index < N; index++) {
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