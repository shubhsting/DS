// https://leetcode.com/problems/design-add-and-search-words-data-structure/
class WordDictionary {
    class Node {
        char ch;
        Node[] neighbour;
        boolean wordEnd;

        Node(char ch) {
            this.ch = ch;
            neighbour = new Node[26];
            wordEnd = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node('#');
    }

    public void addWord(String word) {
        Node current = root;
        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);
            if (current.neighbour[ch - 'a'] == null)
                current.neighbour[ch - 'a'] = new Node(ch);
            current = current.neighbour[ch - 'a'];
        }
        current.wordEnd = true;
    }

    public boolean search(String word) {
        return searchWord(word, root, 0);
    }

    public boolean searchWord(String word, Node current, int start) {

        for (int index = start; index < word.length(); index++) {
            char ch = word.charAt(index);
            if (ch == '.') {
                boolean found = false;
                for (int i = 0; i < 26; i++) {
                    if (current.neighbour[i] != null)
                        found = found || searchWord(word, current.neighbour[i], index + 1);
                }
                return found;
            } else if (current.neighbour[ch - 'a'] == null) {
                return false;
            } else {
                current = current.neighbour[ch - 'a'];
            }
        }
        return current.wordEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
