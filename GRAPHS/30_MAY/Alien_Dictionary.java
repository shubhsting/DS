import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
// https://www.geeksforgeeks.org/problems/alien-dictionary/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution {
    public String findOrder(String[] dict, int N, int K) {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();

        for (int index = 0; index < dict.length - 1; index++) {
            String word1 = dict[index];
            String word2 = dict[index + 1];

            int currentIdx = 0;
            while (currentIdx < word1.length() && currentIdx < word2.length()
                    && word1.charAt(currentIdx) == word2.charAt(currentIdx)) {
                currentIdx = currentIdx + 1;
            }
            if (currentIdx < word1.length() && currentIdx < word2.length()) {
                char start = word1.charAt(currentIdx);
                char end = word2.charAt(currentIdx);
                graph.putIfAbsent(start, new ArrayList<>());
                graph.putIfAbsent(end, new ArrayList<>());
                graph.get(start).add(end);
            }
        }
        return TOPOLOGICAL(graph, N);

    }

    public String TOPOLOGICAL(HashMap<Character, ArrayList<Character>> graph, int n) {
        HashMap<Character, Integer> inorder = new HashMap<>();
        String ans = "";
        for (char ch : graph.keySet()) {
            inorder.putIfAbsent(ch, 0);
            for (char neighbour : graph.get(ch)) {
                inorder.putIfAbsent(neighbour, 0);
                inorder.put(neighbour, inorder.get(neighbour) + 1);
            }
        }
        LinkedList<Character> queue = new LinkedList<>();

        for (char ch : inorder.keySet()) {
            if (inorder.get(ch) == 0) {
                queue.addLast(ch);
            }
        }
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                char current = queue.removeFirst();
                ans += current;
                for (char neighbour : graph.get(current)) {
                    inorder.put(neighbour, inorder.get(neighbour) - 1);
                    if (inorder.get(neighbour) == 0) {
                        queue.addLast(neighbour);
                    }
                }
            }
        }

        return ans;
    }

}
