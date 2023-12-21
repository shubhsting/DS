import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/evaluate-division/description
class Solution {

    class Edge {
        String end;
        double cost;

        Edge(String end, double cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        for (int index = 0; index < equations.size(); index++) {
            List<String> equation = equations.get(index);
            String start = equation.get(0);
            String end = equation.get(1);
            double value = values[index];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(end, new ArrayList<>());
            graph.get(start).add(new Edge(end, value));
            graph.get(end).add(new Edge(start, 1 / value));
        }
        for (int index = 0; index < queries.size(); index++) {
            List<String> query = queries.get(index);
            String start = query.get(0);
            String end = query.get(1);
            ans[index] = BFS(graph, start, end);
        }
        return ans;
    }

    public double BFS(HashMap<String, ArrayList<Edge>> graph, String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        LinkedList<Edge> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.addLast(new Edge(start, 1.0));
        visited.add(start);
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.removeFirst();
                if (current.end.equals(end)) {
                    return current.cost;
                }
                for (Edge neighbour : graph.get(current.end)) {
                    if (!visited.contains(neighbour.end)) {
                        visited.add(neighbour.end);
                        queue.addLast(new Edge(neighbour.end, current.cost * neighbour.cost));
                    }
                }
            }
        }
        return -1.0;
    }
}