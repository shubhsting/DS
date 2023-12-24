import java.util.ArrayList;
import java.util.HashMap;

// https://www.codingninjas.com/studio/problems/identical-sentences_1381853?leftPanelTabValue=PROBLEM
class Solution {
    public static class UnionFind {
        private static HashMap<String, String> parent;
        private static HashMap<String, Integer> rank;

        UnionFind(HashMap<String, String> parent, HashMap<String, Integer> rank) {
            this.parent = parent;
            this.rank = rank;
        }

        public String find(String word) {
            if (!parent.containsKey(word)) {
                return word;
            }
            if (parent.get(word).equals(word)) {
                return word;
            }

            String foundWord = find(parent.get(word));
            parent.put(word, foundWord);
            return foundWord;
        }

        public void union(String word_1, String word_2) {
            String parent_1 = find(word_1);
            String parent_2 = find(word_2);
            if (rank.get(parent_1) > rank.get(parent_2)) {
                parent.put(parent_2, parent_1);
            } else if (rank.get(parent_2) > rank.get(parent_1)) {
                parent.put(parent_1, parent_2);
            } else {
                parent.put(parent_1, parent_2);
                rank.put(parent_1, rank.get(parent_1) + 1);
            }
        }
    }

    public static boolean identicalSentences(ArrayList<String> word1, ArrayList<String> word2,
            ArrayList<ArrayList<String>> pairs, int n, int m, int p) {
        if (word1.size() != word2.size()) {
            return false;
        }
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Integer> rank = new HashMap<>();
        UnionFind uf = new UnionFind(parent, rank);
        for (ArrayList<String> pair : pairs) {
            parent.putIfAbsent(pair.get(0), pair.get(0));
            parent.putIfAbsent(pair.get(1), pair.get(1));
            rank.putIfAbsent(pair.get(0), 1);
            rank.putIfAbsent(pair.get(1), 1);
            uf.union(pair.get(0), pair.get(1));
        }

        for (int index = 0; index < n; index++) {
            if (!uf.find(word1.get(index)).equals(uf.find(word2.get(index)))) {
                return false;
            }
        }
        return true;
    }
}
