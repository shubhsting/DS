import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    class Edge {
        String word;
        Integer changesSoFar;

        Edge(String word, Integer changesSoFar) {
            this.word = word;
            this.changesSoFar = changesSoFar;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<Edge> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> words = new HashSet<>();
        for (String word : wordList) {
            words.add(word);
        }
        queue.addLast(new Edge(beginWord, 1));
        visited.add(beginWord);
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Edge current = queue.removeFirst();
                if (current.word.equals(endWord)) {
                    return current.changesSoFar;
                }
                for (int index = 0; index < current.word.length(); index++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] wordCharArray = current.word.toCharArray();
                        wordCharArray[index] = ch;
                        String word = String.valueOf(wordCharArray);
                        if (words.contains(word) && !visited.contains(word)) {
                            visited.add(word);
                            queue.addLast(new Edge(word, current.changesSoFar + 1));
                        }
                    }
                }

            }
        }
        return 0;
    }

}