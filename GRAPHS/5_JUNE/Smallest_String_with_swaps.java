import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/smallest-string-with-swaps/submissions/
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        ArrayList<Integer>[] graph = new ArrayList[s.length()];
        for (int index = 0; index < graph.length; index++) {
            graph[index] = new ArrayList<>();
        }
        for (List<Integer> pair : pairs) {
            int start = pair.get(0);
            int end = pair.get(1);
            graph[start].add(end);
            graph[end].add(start);
        }

        boolean[] visited = new boolean[graph.length];
        char[] finalString = s.toCharArray();
        for (int index = 0; index < visited.length; index++) {
            if (!visited[index]) {
                List<Character> words = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                DFS(graph, visited, words, indices, index, s);
                words.sort((Character a, Character b) -> {
                    return a - b;
                });
                indices.sort((Integer a, Integer b) -> {
                    return a - b;
                });
                for (int i = 0; i < words.size(); i++) {
                    finalString[indices.get(i)] = words.get(i);
                }
            }
        }
        return String.valueOf(finalString);
    }

    public void DFS(ArrayList<Integer>[] graph, boolean[] visited, List<Character> words, List<Integer> indices,
            int current, String s) {
        visited[current] = true;
        words.add(s.charAt(current));
        indices.add(current);
        for (Integer neighbour : graph[current]) {
            if (!visited[neighbour]) {
                DFS(graph, visited, words, indices, neighbour, s);
            }
        }
    }
}
