import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
// https://leetcode.com/problems/reconstruct-itinerary/description/
// It is eulers path question
// Complexity: O(V+E)[DFS complexity]
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);
            graph.putIfAbsent(start, new PriorityQueue<>());
            graph.get(start).add(end);
        }

        List<String> ans = new ArrayList<>();
        DFS_EULER_PATH(graph, "JFK", ans);
        return ans;
    }

    public void DFS_EULER_PATH(HashMap<String, PriorityQueue<String>> graph, String current, List<String> ans) {
        if (graph.containsKey(current)) {

            PriorityQueue<String> neighbours = graph.get(current);
            while (neighbours.size() > 0) {
                String neighbour = neighbours.poll();
                DFS_EULER_PATH(graph, neighbour, ans);
            }
        }
        ans.add(0, current);
    }
}
