// https://leetcode.com/problems/concatenated-words/
class Solution {
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

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Node root = new Node('#');
        for (String word : words)
            insert(word, root);
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (haveConcatenatedWords(word, 0, root, 0))
                ans.add(word);
        }
        return ans;
    }

    public void insert(String word, Node root) {
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

    public boolean haveConcatenatedWords(String word, int startIdx, Node root, int count) {
        if (startIdx >= word.length())
            return count >= 2;
        // if(count>2) return true;
        Node current = root;
        for (int index = startIdx; index < word.length(); index++) {
            char ch = word.charAt(index);
            if (current.neighbour[ch - 'a'] == null)
                return false;
            current = current.neighbour[ch - 'a'];
            if (current.wordEnd) {
                if (haveConcatenatedWords(word, index + 1, root, count + 1))
                    return true;
            }
        }
        return false;
    }
}