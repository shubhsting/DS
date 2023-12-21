import java.util.ArrayList;

class Solution {
    // https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> ans = new ArrayList<>();
        DFS(graph, new boolean[V], 0, ans);
        return ans;

    }

    public void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int node, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        for (Integer neighbour : graph.get(node)) {
            if (!vis[neighbour]) {
                DFS(graph, vis, neighbour, ans);
            }
        }
    }
}