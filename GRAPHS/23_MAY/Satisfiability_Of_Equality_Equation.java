class Solution {
    // https://leetcode.com/problems/satisfiability-of-equality-equations/description/
    class UnionFind {

        private int[] parent;
        private int[] rank;

        UnionFind(int[] parent, int[] rank) {
            this.rank = rank;
            this.parent = parent;
        }

        public int search(int characterIndex) {
            if (parent[characterIndex] == characterIndex) {
                return characterIndex;
            }
            parent[characterIndex] = search(parent[characterIndex]);
            return parent[characterIndex];
        }

        public void union(int characterIndex_1, int characterIndex_2) {
            int parent_1 = search(characterIndex_1);
            int parent_2 = search(characterIndex_2);

            if (rank[parent_1] > rank[parent_2]) {
                parent[parent_2] = parent_1;
            } else if (rank[parent_2] > rank[parent_1]) {
                parent[parent_1] = parent_2;
            } else {
                parent[parent_1] = parent_2;
                rank[parent_2]++;
            }
        }
    }

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        for (int index = 0; index < 26; index++) {
            parent[index] = index;
            rank[index] = 1;
        }
        UnionFind uf = new UnionFind(parent, rank);
        for (String equation : equations) {
            char character_1 = equation.charAt(0);
            char character_2 = equation.charAt(3);
            if (equation.charAt(1) == '=') {
                if (uf.search(character_1 - 'a') != uf.search(character_2 - 'a')) {
                    uf.union(character_1 - 'a', character_2 - 'a');
                }
            }
        }

        for (String equation : equations) {
            char character_1 = equation.charAt(0);
            char character_2 = equation.charAt(3);
            if (equation.charAt(1) == '!') {
                if (uf.search(character_1 - 'a') == uf.search(character_2 - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}