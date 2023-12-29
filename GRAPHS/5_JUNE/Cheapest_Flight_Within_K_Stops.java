// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    class Edge {
        int end;
        int cost;

        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    class EdgeMetadata {
        int end;
        int noOfStops;
        int costSoFar;

        EdgeMetadata(int end, int noOfStops, int costSoFar) {
            this.end = end;
            this.noOfStops = noOfStops;
            this.costSoFar = costSoFar;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            graph[index] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            graph[from].add(new Edge(to, cost));
        }
        LinkedList<EdgeMetadata> queue = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        queue.add(new EdgeMetadata(src, -1, 0));
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                EdgeMetadata current = queue.remove();
                if (current.noOfStops > k) {
                    continue;
                }
                for (Edge neighbour : graph[current.end]) {
                    if (current.noOfStops < k && neighbour.cost + current.costSoFar < distance[neighbour.end]) {
                        distance[neighbour.end] = current.costSoFar + neighbour.cost;
                        queue.add(new EdgeMetadata(neighbour.end, current.noOfStops + 1,
                                current.costSoFar + neighbour.cost));
                    }
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

}