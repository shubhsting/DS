
class Solution {

    public int[] shortestPath(int N, int M, int[][] edges) {
        int[] cost = new int[N];

        for (int i = 0; i < N; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[0] = 0;
        for (int iteration = 0; iteration < N - 1; iteration++) {
            for (int index = 0; index < edges.length; index++) {
                int start = edges[index][0];
                int end = edges[index][1];
                int edgeWeight = edges[index][2];
                if (cost[start] != Integer.MAX_VALUE) {
                    cost[end] = Math.min(cost[end], cost[start] + edgeWeight);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                cost[i] = -1;
            }
        }
        return cost;
    }
}