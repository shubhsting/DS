// https://leetcode.com/problems/word-search-ii/
class Solution {

    class Node {
        char ch;
        Node[] neighbour;
        boolean wordEnd;
        String word;
        Node(char ch) {
            this.ch = ch;
            neighbour = new Node[26];
            wordEnd = false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node('#');
        for(String word: words) insert(word, root);
        List<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        int n = board.length;
        int m = board[0].length;
        if(n == 1 && m == 1) {
            Node temp = root.neighbour[board[0][0] - 'a'];
            if(temp !=null && temp.wordEnd) ans.add(temp.word);
            return ans;
        }
        for(int row = 0; row<board.length; row++) {
            for(int column = 0; column<board[0].length; column++) {
                DFS(row, column, root, board, ans, vis);   
            }
        }
        return ans;
    }

    public void insert(String word, Node root) {
        Node temp = root;
        for(int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);
            if(temp.neighbour[ch - 'a'] == null) {
                temp.neighbour[ch - 'a'] = new Node(ch);
            } 
            temp = temp.neighbour[ch - 'a'];
        }
        temp.wordEnd = true;
        temp.word = word;
    }

    int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    public void DFS(int row, int column, Node current, char[][] board, List<String> ans, boolean[][] vis) {
        if(current.wordEnd) {
            ans.add(current.word);
            current.wordEnd = false;
        }
        for(int[] direction: directions) {
            int r = row + direction[0];
            int c = column + direction[1];
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && !vis[r][c] && current.neighbour[board[r][c] - 'a'] != null) {
                vis[r][c] = true;
                DFS(r, c, current.neighbour[board[r][c] - 'a'], board, ans, vis);
                vis[r][c] = false;
            } 
        }
    }
}