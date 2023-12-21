import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    // https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList();
        queue.add(0);
        boolean[] visited = new boolean[V + 1];
        visited[0] = true;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int currentNode = queue.removeFirst();
                ans.add(currentNode);
                for (Integer neighbour : graph.get(currentNode)) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        queue.addLast(neighbour);
                    }
                }
            }
        }
        return ans;
    }
}