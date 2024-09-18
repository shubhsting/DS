// https://leetcode.com/problems/longest-common-prefix/description
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String word : strs) {
            if (word.length() == 0)
                return "";
            trie.add(word);
        }
        String lcp = trie.LCP();
        return lcp.substring(1, lcp.length());
    }

    class Trie {
        class Node {
            Node[] neighbour;
            boolean isEnd;
            char ch;

            public Node(char ch) {
                this.ch = ch;
                this.isEnd = false;
                this.neighbour = new Node[26];
            }
        }

        Node root;

        public Trie() {
            root = new Node('#');
        }

        public void add(String word) {
            Node current = root;
            for (int index = 0; index < word.length(); index++) {
                char ch = word.charAt(index);
                if (current.neighbour[ch - 'a'] == null)
                    current.neighbour[ch - 'a'] = new Node(ch);
                current = current.neighbour[ch - 'a'];
            }
            current.isEnd = true;
        }

        public String LCP() {
            Node current = root;
            String ans = "";
            while (hasOneElement(current.neighbour) != null && !current.isEnd) {
                ans = ans + current.ch;
                current = hasOneElement(current.neighbour);
            }
            return ans + current.ch;
        }

        private Node hasOneElement(Node[] neighbours) {
            int count = 0;
            Node next = null;
            for (Node neighbour : neighbours) {
                if (neighbour != null) {
                    count++;
                    next = neighbour;
                }
            }
            return count == 1 ? next : null;
        }
    }
}

// time complexity S
// space complexity recursive

class Solution {
    public String longestCommonPrefix(String[] strs) {
        return LCP(strs, 0, strs.length - 1);
    }

    public String LCP(String[] strs, int start, int end) {
        if (start > end)
            return "";
        if (start == end)
            return strs[start];
        int mid = start + (end - start) / 2;
        String left = LCP(strs, start, mid);
        String right = LCP(strs, mid + 1, end);
        return LPS(left, right);
    }

    public String LPS(String s1, String s2) {
        int index = 0;
        String ans = "";
        while (index < s1.length() && index < s2.length()) {
            if (s1.charAt(index) == s2.charAt(index))
                ans = ans + s1.charAt(index);
            else
                return ans;
            index++;
        }
        return ans;
    }
}

//vertical scan
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        for(int index = 0; index<strs[0].length(); index++) {
            char ch = strs[0].charAt(index);
            boolean isPresent = true;
            for(String word: strs) {
                if(index<word.length() && word.charAt(index) == ch) isPresent = true;
                else {isPresent = false; break;}
            }
            if(isPresent) ans=ans+ch;
            else return ans;
        }
        return ans;
    }
}