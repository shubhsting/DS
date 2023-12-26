package GRAPHS.MISC;

import java.util.ArrayList;
import java.util.PriorityQueue;
// https://leetcode.com/problems/parallel-courses-iii/description/
// kahns + kruskals algo
class Solution {
    class Edge {
        int node;
        int timeSoFar;

        Edge(int node, int timeSoFar) {
            this.node = node;
            this.timeSoFar = timeSoFar;
        }
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] inorder = new int[n + 1];
        for (int index = 1; index <= n; index++) {
            graph[index] = new ArrayList<>();
        }
        for (int[] relation : relations) {
            inorder[relation[1]]++;
            graph[relation[0]].add(relation[1]);
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>((Edge a, Edge b) -> {
            return a.timeSoFar - b.timeSoFar;
        });
        for (int index = 1; index <= n; index++) {
            if (inorder[index] == 0) {
                queue.add(new Edge(index, time[index - 1]));
            }
        }
        int ans = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.remove();
                ans = Math.max(current.timeSoFar, ans);
                for (int visited : graph[current.node]) {
                    inorder[visited] = inorder[visited] - 1;
                    if (inorder[visited] == 0) {
                        queue.add(new Edge(visited, current.timeSoFar + time[visited - 1]));
                    }
                }
            }
        }
        return ans;
    }
}