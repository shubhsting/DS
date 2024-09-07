// https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {
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

    public Trie() {
        root = new Node('#');
    }

    public void insert(String word) {
        Node temp = root;
        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);
            if (temp.neighbour[ch - 'a'] == null) {
                temp.neighbour[ch - 'a'] = new Node(ch);
            }
            temp = temp.neighbour[ch - 'a'];
        }
        temp.wordEnd = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);
            if (temp.neighbour[ch - 'a'] == null)
                return false;
            temp = temp.neighbour[ch - 'a'];
        }
        return temp.wordEnd;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (int index = 0; index < prefix.length(); index++) {
            char ch = prefix.charAt(index);
            if (temp.neighbour[ch - 'a'] == null)
                return false;
            temp = temp.neighbour[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */